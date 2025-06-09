-- 1.기본문법
-- SQL문 종류
-- 1)DDL(Data Definition Language) 데이터 정의어 - Create Drop Alter 등
-- 2)DML(D Manipulation L) 데이터 조작어 - Select Update Insert Delete 등
-- 3)DCL(D Control L) 데이터 제어어 - Grant Revoke Commit Rollback 등
-- 컬럼은 자원 한개를 저장하는 공간이다.
-- 컬럼들은 자료형이 있어야함. 
-- 자료형들
-- -문자형:char(길이),varchar(길이),Text
-- -날짜형:Date Datetime Timestamp
-- -정수형 : int(길이) Bigint(길이)
-- -고정소수점: Decimal Numberic

-- 조작어
-- 테이블에서 자원들을 추출하는 SQL문 작성
-- SELECT [컬럼명 또는 *] FROM [테이블명]
	Select * from emp; 
-- 문제)emp테이블에서 사번,이름,부서코드 순으로 출력하는 SQL문장을 완성하시오
	select empno,ename,deptno from emp;
-- Select문은 자원검색에 사용되는 문장이다.
-- 전체 데이터 확인하기 : select* from [테이블명];

-- 컬럼명을 기술하면서 자원 검색하기
-- select empno,ename,deptno from emp;

-- 조건부여(where절)
-- 일반적으로 테이블에 있는 자원들을 조회할 때가 많다.
-- 이 떄 사용자가 원하는 자원들을 간단한 연산자 등을 이용하여
-- where절에 조건으로 기술하면 결과를 얻을 수 있다.
-- ex) 사원테이블에서 부서(deptno)가 10번인 사원들의 정보를 사번/이름/입사일/부서코드 순으로 출력하자
	Select empno,ename,hiredate,deptno
		from emp 
		where deptno=10;
-- 문제) 사원 테이블에서 직종(job)이 SALESMAN인 사원들의 정보를 사번/이름/부서코드/직종 순으로 출력하자

select empno,ename,deptno,job from emp where job='SALESMAN';

-- 문제) 사원 테이블에서 사번이 1500번 이상인 사원들의 정보를 사번,이름,급여,입사일 순으로 출력하라
select empno,ename,sal,hiredate from emp where empno>=1500;
-- 주의
-- 1.비교연산자는 ==이 아니라 =로 같은 값을 비교한다
-- 2.문자열을 의미할 때는 쌍따옴표가 아니라 홑따옴표로 표기한다

-- 문제) 사원테이블에서 1981년도에 입사한 사원들의 사번,이름,입사일,부서코드 순으로 출력하시오
select empno,ename,hiredate,deptno from emp
	where hiredate>='1981-01-01' 
	and hiredate<='1981-12-31';

-- 문제) 사원테이블에서 10번부서에 1981년도에 입사한 사원들의 정보 를번,이름,입사일,부서코드 순으로 출력하시오
select empno,ename,hiredate,deptno from emp 
	where deptno=10 
	and hiredate>='1981-01-01' 
	and hiredate<='1981-12-31';

-- 정렬(order by 절)
-- 특정 칼럼을 중심으로 오름차순 또는 내림차순으로 정렬을 시켜 출력하고자 할때 사용
-- ex) 1981년에 입사한 사원을 출력할때, 가장 최근에 입사한 순서로 출력
select empno,ename,hiredate,deptno from emp 
	where hiredate>='1981-01-01' 
    and hiredate<='1981-12-31' 
    order by hiredate desc; 
-- 오름차순 : ASC 내림차순:DESC
-- -------------------------------------------------------------------------------------------------
-- 2. SQL연산자
-- 1)Beteween 연산자
-- 		특정 값 A에서 특정 값 B의 사이(범위)의 정보를 얻을 때 사용한다.
--  	ex)사원 테이블에서 입사일이 1981년도인 사원들의 정보
select * from emp where hiredate between '1981-01-01'and'1981-12-31';
-- 문제)사원 테이블에서 사번이 1100~1500사이의 사원등ㄹ 정보를 사번,이름,직종,부서코드 순으로 출력
select empno,ename,job,deptno from emp where empno between 1100 and 1500;

-- 2)In 연산자
-- 		특정 목록의 결과값에서 비교값이 속하는지?를 가려내는 연산자다.(OR)
--  구성
-- 		where [컬럼명] in(값1,값2,값3,...,값n);
select * from emp where empno in (1200,1201,1210);
select * from emp where empno =1200 or empno =1201 or empno =1210; -- 위 코드와 같은 동작
-- 문제)사원테이블에서 직종이 'SALESMAN'또는 'DEVLOP'직의 사원들의 사번,이름,직종,부서코드 순으로 출력
select empno,ename,job,deptno,sal from emp 
	where job in('SALESMAN','DEVLOP');
-- 문제)사원테이블에서 직종이 'SALESMAN'또는 'DEVLOP'직의 사원들중 급여를 1500이상 받는 사원의 사번,이름,직종,부서코드 순으로 출력
select empno,ename,job,deptno from emp 
	where job in('SALESMAN','DEVLOP') and sal>=1500;
-- 3)Like 연산자
-- 	지정한 문자형태와 일치한 자원들을 검색할 때 사용한다.
-- [형식]
-- 1) % : 모든 값
-- 2)_ : 하나의 값
-- 예시1)'M%' : M으로 시작하는 모든 값 ex)Michael Mother Monster
-- 예시2)'%n' : n으로 끝나는 모든 값 ex)incheon jason miyeon person 
-- 예시3)'%a%' : 문자열 어디든 a가 포함되어있는 모든 값 ex)apple banana calymba rapid apart
-- 예시4) '_a' : 문자열이 두자인데,a로끝나는 값 ex)Na ba ca da ea...
-- 문제) 총 7자이면서 M으로 시작하는 값을 의미하는 문자형식은 무엇인가?  'M______'
-- 문제2)사원 테이블에서 입사일이 1981년에 입사한 사원들의 정보를 사번,이름,직종,입사일 순으로 출력하자!(단, Like연산자를 활용)
Select empno,ename,job,hiredate from emp
where hiredate Like '1981%';

-- ---------------------------------------------------------------------------------
-- 3.SQL함수
-- 기본적으로 쿼리문을 더욱 강력하게 하고, 데이터 값을 조작하는데 있어 도움이 되는것이 바로 SQL함수이다.
-- SQL함수의 특징과 장점 - 자원에 대한 연산을 수행할 수 있다./개별적인 데이터 항목을 수행할 수 있다./그룹화 작업에도 용이하다

-- SQL함수의 종류
-- 1)문자함수(변환,조작)

-- 	-변환함수
-- 		Lower(컬럼명 또는 값): 알파벳 값을 소문자로 변환
-- 		Upper(컬럼명 또는 값): 알파벳 값을 대문자로 변환
-- 		INITCAP(컬럼명 또는 값) : 알파벳 첫 문자만 대문자로 변환
-- 예)사원테이블에서 직종이 'SALESMAN'인 사원들의 정보를 사번,이름,직종 순으로 출력
select empno,ename,job from emp where Lower(job)='salesman';

-- -조작함수
-- 	Concat : 두 문자열을 연결
-- 	Substr : 특정 문자나 문자열을 추출(자바의 substring)
-- 	Substring:
-- 	Left : 왼쪽부터 지정한 길이만큼 추출
-- 	Right : 오른쪽부터 지정한 길이만큼 추출
--  Length : 문자열의 길이
-- 	Instr : 명시도니 문자열의 위치값(자바의 indexof)
-- 	Ltrim : 문자열의 왼쪽에 있는 공백 제거 : " Test" -> "TEST"
-- 	Rtrim : 문자열의 오른쪽에 있는 공백 제거 : " Test " -> " TEST"
-- 	Reverse : 문자열의 순서를 역순으로 만든다.

-- ex)사원테이블에서 각 사원들의 직종의 3번째 문자값을 추출하여 출력해보자. 출력할 칼럼명은 사번,이름,직종 순이다
select empno,ename,job,substr(job,3,1) as sub1,substring(job,3,2),length(job) from emp;

-- 문제)사원테이블에서 각 사원들의 직종 값에 있는 "S'의 위치값을 알아내자!
select job,instr(job,'S') from emp;

-- 2)숫자함수
-- 	Round : 반올림
select round(1205.4,0),round(1205.54,-2),round(1205.54,1);
-- 	Ceil : 소수점 이하를 자르면서 올림(2.423 -> 3)
		select Ceil(2.00000000000000001);
-- 	Floor : 소수점 이하를 자르면서 버림(2.423->2)
		select floor(3.75);
-- 	POW : 거듭제곱
select pow(1,4);
-- 	MOD : 나머지값
-- 	Greatest : 최대값
-- 	Least : 최소값
select mod(4,3),greatest(1,2,3,4,5),least(1,2,3,4,5);

-- 3)날짜함수
-- 	weekday(날짜):요일(월0 화-1 수-2....일-6)
-- 	dayofweek(날짜):한 주의 요일(일:1,월:2,...,토:7)
select now(),dayofweek(now()),dayofweek('2025-12-28');
-- dayofmonth(날짜) : 그 달에 몇번째 날인지 알아낸다.
-- dayofyear(날짜) : 그 해에 몇번째 날인지 알아낸다.
select now(),dayofyear(now()),dayofyear('2025-12-28');
-- month(날짜) : 해당 날짜의 월 반환
-- year(날짜) : 해당 날짜의 년도 반환
-- dayname(날짜) : 요일 명을 반환
-- quarter(날짜) : 분기 반환(1~4)
select month(now()),year(now()),dayname(now()),quarter(now());

-- period_add(날짜형식,더할_월수)
	select now(),period_add(202411,2);
-- period_diff(현재 년월,입사 년월)두 날짜 사이의 개월 수를 반환
	select now(),period_diff(202506,202411);
-- 현재 날짜는 now()이다. 여기서 년도와 월을 구하는 방법
-- ex)사원테이블에서 각 사원들이 현재까지 몇개월 째 일을 하는지 알아보자
select concat(substr(hiredate,1,4),substr(hiredate,6,2))from emp as now;

select empno,ename,now(),period_diff(concat(substr(now(),1,4),substr(now(),6,2)),concat(substr(hiredate,1,4),substr(hiredate,6,2))) from emp; 
-- date_format(날짜,형식)
-- 형식은 정해지는 것에 따라 날짜 또는 시간을 출력한다.
-- [형식]
-- '%m' : 월 이름
-- '%w' : 요일 이름
-- '%d' : 일(몇 일)
-- '%Y' : 4자리 년도, 소문자y는 2자리 년도
-- '%H' : 24시간 형식의 시간, 소문자h는 12시간제
-- '%i' : 분(0~59)
-- '%s' : 초(0~59)
select now(),date_format(now(),'%Y%m%d') as c_date;
select empno,ename,now(),period_diff(date_format(now(),'%Y%m'),date_format(hiredate,'%Y%m')) as 근속월수 from emp;
