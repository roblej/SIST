-- DDL(Data Definition Language):데이터 정의어 - create, alter, drop
-- 테이블 생성법
-- create table [테이블명] (
-- [컬럼명1] [자료형(길이)],
-- [컬럼명2] [자료형(길이)],
-- ...
-- [컬럼명n] [자료형(길이)]
-- CONSTRAINT [제약조건명][제약조건]
-- );

-- 도서들을 저장하는 테이블을 생성해보자
-- 하나의 도서 정보(도서명,저자,출판사,도서고유번호,가격,등록일,...)
create table book_t(
b_idx bigint(4) auto_increment,
title char(100),
author varchar(50),
press varchar(50),
b_price decimal(9,1),
constraint book_t_pk primary key(b_idx)
);
-- 테이블 수정(컬럼추가)
-- 등록일 컬럼을 추가한다
-- 등록일 컬럼ㅇ르 press컬럼 뒤에 추가할 때 어떻게 해야 하나?
alter table book_t
add column reg_date date;
-- 이러면 맨 뒤로 들어감
alter table book_t
add column reg_date date null after press; -- press 뒤에 들어감,null을 기본값으로

-- 테이블 수정(컬럼의 자료형 변경)
alter table book_t
modify title varchar(100);

-- 테이블 수정(컬럼명 수정)
alter table book_t
rename column title to subject;
-- 테이블 수정(컬럼 삭제)
alter table book_t
drop column press;

-- 회원정보(member_t)를 저장하는 테이블이 필요
-- 정보는 회원명,이메일,연락처 반드시 필요
create table member_t(
m_idx bigint(4) auto_increment,
m_name varchar(20),
e_mail varchar(100),
phone varchar(20),
constraint member_pk primary key(m_idx)
);

-- 데이터 추가
-- 구성
-- insert into 테이블명(컬럼명1,컬럼명2,..,컬럼명n)
-- values(값1,값2,...,값n);
-- 주의)명시한 컬럼의 수와 값의 수가 일치해야 한다.
insert into member_t(m_name,m_email,m_phone)
values('마루치','maru@korea.com','010-1234-5678');    

insert into member_t(m_name,m_email,m_phone)
values('아라치','maru@korea.com','010-1234-5678');
commit; -- 오토커밋해제하면 이렇게 해야함

-- 데이터 확인
 select * from member_t;
insert into member_t(m_name,m_email) values ('이도','');
insert into member_t(m_name) values ('이산');

-- 회원등록날짜를 저장하는 컬럼을 추가하려면...
alter table member_t add write_date date null;

-- member_t에서 write_date라는 컬럼을 reg_date로 변경
alter table member_t rename column write_date to reg_date;

-- 데이터 수정(update)
-- 구성 : update [테이블명] set [변경할 정보가 있는 컬럼명] = [변경할 값] where [조건식];
update member_t set reg_date =20250611 where m_idx = 2;
update member_t set m_email='test@korea.com' where m_idx = 2;

-- m_idx가 1인 회원의 이메일을 'maru@korea.com'으로 변경!
update member_t set m_email='maru@korea.com' where m_idx = 1;
update member_t set m_email='ara@korea.com' where m_idx = 2;
update member_t set m_name = '을불' where m_idx = 8;

-- 데이터 삭제
-- 구성 : delete from [테이블명] where [조건식];
-- m_idx값이 2인 자원 삭제
delete from member_t where m_idx=2;
-- m_idx값이 20,308,5번인 자원 삭제
delete from member_t where m_idx in(20,308,5);

-- 테이블 삭제(drop table)
-- 구성 :drop table [테이블명]

-- 계정생성과 권한부여 : DCL(data control l)
-- 사용자계정을 생성하려면 우선 관리자계정(root)으로 로그인이 되어야 한다.
-- 구성 : 현재 서버에서만 접속할 수 있는 계정 생성
-- Create user '사용자계정'@'localhost' identified by '비밀번호';
-- 해당 ip에서만 접속할 수 있는 계정 생성
-- Create user '사용자계정'@'해당ip주소' identified by '비밀번호';
-- 해당 ip영역대에서만 접속할 수 있는 계정 생성
-- Create user '사용자계정'@'192.168.%' identified by '비밀번호';
-- 어디에서든 접속할 수 있는 계정 생성
-- Create user '사용자계정'@'%' identified by '비밀번호';

create user 'test_admin'@'%' identified by '1111';

-- 계정은 생성 되었으나, my_db에 접속 불가->권한부여(db를 생성한 계정이 부여해야함)
-- 해당 db의 모든 객체에 대한 모든 권한을 주는 법
-- Grant all privileges on *.* to '계정명'@'호스트(주소)';

-- 해당 db의 모든 객체에 대한 select와 insert 권한을 주는 법
-- Grant select,insert privileges on *.* to '계정명'@'호스트(주소)';

-- test_admin에게 my_db의 모든 객체들에게 모든 권한을 부여
grant all privileges on my_db.* to 'test_admin'@'%';

-- 권한 회수
-- 구성 : revoke all privileges on my_db.* from 'test_admin'@'%';
-- test_admin계정에 부여한 권한을 회수하자!
revoke all on my_db.* from 'test_admin'@'%';

-- 모델링
-- 그림을 판매하는 프로그램 구현
-- 예술품(그림)정보가 저장되는 테이블 작성
-- (제목,작가,유형,가격,제작년도,등록일)
drop table member_t;

create table art_t(
art_idx bigint(4) auto_increment,
subject varchar(100) not null,
author varchar(50) not null,
type varchar(30),
price decimal(9,2),
make_year varchar(20),
reg_date date,
constraint art_t_pk primary key(art_idx)
);
-- 회원정보(회원명,아이디,비밀번호,연락처,주소,등록일)
create table member_t(
m_idx bigint(5) auto_increment,
m_name varchar(50) not null,
m_id varchar(30) not null,
m_pw varchar(50) not null,
m_phone varchar(20) not null,
m_addr varchar(50),
reg_date date,
status int(1) Default 0,
etc1 varchar(10),
etc2 varchar(10),
constraint member_t_pk primary key(m_idx)
);

-- 판매 정보를 저장하는 테이블 작성
-- 판매할 그림 정보, 구매하는 회원정보, 판매일, 거래일, 상태
create table sales_t(
s_idx bigint(6) auto_increment,
art_idx bigint(4) not null,
m_idx bigint(5) not null,
start_date date not null,
sale_date date,
status int(1) default 0,
constraint sales_t_pk primary key(s_idx),
constraint sales_t_fk1 foreign key(art_idx) references art_t(art_idx),
constraint sales_t_fk2 foreign key(m_idx) references member_t(m_idx)
);