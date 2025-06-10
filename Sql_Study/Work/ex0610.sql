-- 1.암시적 형변환
-- 	1)날짜 자료형의 값들은 자동으로 문자열로 변환됨
--  2)'1200'과 같은 숫자가 문자열로 된 자원들은 숫자로 자동 변환됨
--  3) 1200과 같은 숫자가 문자열로 자동 변환됨
-- 2.명시적 형변환
--  1) SQL문장 내에서 변환함수를 사용하여 특정 자원을 원하는 자료형으로 변환하는것
-- 		ex) date_format함수를 이용하여 날짜 자원을 만드는 행위
		-- select case('100',as unsigned) as num;
-- 3.데이터 그룹화
--  지금까지는 각 테이블 자체가 하나의 그룹이었고,이제는 각 테이블에서 소그룹을 만들어 결과를 소그룹별로 얻고자 할때
--  그룹생성법을 알아야 가능하다.
-- 예)emp테이블에서 각 부서별 인원수를 출력하자!
select deptno,count(*) as count from emp group by deptno order by deptno;

-- 예)emp테이블에서 각 부서별 인원수,그리고 급여의 평균과 총액을 구하자!
select deptno,count(*),avg(sal),sum(sal),max(sal),min(sal) from emp group by deptno order by deptno;

-- 문제)emp테이블에서 직종별 (job)급여의 합과 평균을 구하시오
select job,avg(sal),sum(sal) from emp group by job;
-- 문제)emp테이블에서 각 부서별 보너스(comm)의 합,평균 그리고 인원수를 순서대로 출력
-- comm에 null은 0으로 대체하는 문장 -> ifnull(comm,0)
select deptno,sum(ifnull(comm,0)),avg(ifnull(comm,0)),count(*) as num from emp group by deptno;

-- NULL값을 다른 값으로 대체할 떄는 IFNULL함수 사용
-- 오라클에서는 NVL함수를 사용한다. 만약 특정 부서 인원들 중 3명이 보너스를 받지 못하여 null일 경우 평균을 구할때 그 3명은 평균 연산에서 제외된다.
-- 그렇지 않고 전체 인원으로 평균을 구해야 한다면 ifnull함수로 null을 0으로 대체하여 연산에 참여하도록 한다.

-- ex) emp 테이블에서 연봉을 계산하는 select문장을 기술해보자(급여*보너스)
select*,sal*ifnull(comm,1) from emp;

-- ex)분석가들의 급여 평균을 구하자!
select job,avg(sal) from emp where job = 'analyst';
select job,avg(sal) from emp where job = 'analyst' group by job;

-- SQL문의 실행 순서
-- 	From과 Join -> Where-> Groub By -> Having -> Select -> Order By
-- 문제) emp테이블에서 직종이 'CLERK'또는 'SALESMAN'인 사원들 중 최대급여를 구하는 SELECT문은?
select max(sal) from emp where job in ('clerk','salesman');
-- 위는 직종이 clerk과 salesman들을 모두 합하여 최대값을 구한다. 따로 구하고 싶다면 그룹화를 해야함
select job,max(sal) from emp where job in ('clerk','salesman') group by job;

-- ex) emp테이블에서 각 부서별 인원수,급여의 합을 구하는 select문을 구하자
select deptno, count(*),sum(sal) from emp group by deptno;
-- 위 결과에서 인원수 7명 이상인 부서만 확인하고싶다!
select deptno, count(*),sum(sal) from emp group by deptno having count(*)>=7;
-- 조건식에 그룹함수(Max,Min,Sum,Avg,Count,....)가 포함된다면 where절에 기술 x having절에 기술

-- 4. SUBQUERY
-- 	서브쿼리는 특정 SQL문장 안에 또 다른 SQL문장이 포함된 것
--  [장점]
--  DB에 여러번 접속해야 하는 상황을 한번에 처리가 가능하게 해준다.
--  한마디로 DB접속되는 횟수를 ㅈ루이고, 속도를 증가시킴

-- 서브쿼리를 사용할 수 있는곳
--  WHERE,HAVING
--  INSERT 구문에 INTO
--  UPDATE 구문에 SET
--  SELECT 또는 DELETE 구문의 FROM

-- EX)EMP테이블에서 사원 이름이 'SMITH'이고 직종이 'CLERK'인 사원의 급여보다 더 많이 받는 사원들의 정보를 사번,이름,직종,급여순으로 출력하자
SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE(SELECT SAL FROM EMP WHERE ENAME='SMITH' AND JOB='CLERK')<SAL;

-- 문제)EMP테이블에서 사번이 7521번인 사원의 직종과 같고, 7844번 사원의 급여보다 많이 받는 사원들의 정보를 사번,이름,직종,급여,입사일 순으로 출력하라
SELECT EMPNO,ENAME,JOB,SAL,HIREDATE FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE EMPNO=7521) AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7844);

-- 문제) EMP테이블에서 급여가 3000 이상인 사원들 중 입사일이 1982년 이전에 입사한 사원들의 정보를 사번,이름,급여,입사일 순으로 출력하자!
SELECT EMPNO,ENAME,SAL,HIREDATE FROM EMP WHERE HIREDATE<'1982-01-01' AND SAL>=3000;
-- SUBQUERY사용 시
SELECT a.EMPNO,a.ENAME,a.SAL,a.HIREDATE FROM(SELECT * FROM EMP WHERE SAL>=3000) a WHERE A.HIREDATE < '1982-01-01';

-- 예)급여가 3000 이상인 사원들의 부서코드와 부서명을 출력하자!
select distinct deptno from emp where sal>=3000;
select deptno,dname from dept where deptno IN(select distinct deptno from emp where sal>=3000);

-- 5.Join
-- DB의 TABLE들 간 결합을 의미. 참조값에 의해서 연결
-- 여러개의 테이블에 자원들이 흩어져있는 상태에서 데이터를 마치 하나의 테이블에서 보는 것 처럼 결과를 내고 싶을 때 JOIN을 사용한다

-- ex)원하는 결과가 다음과 같다면 -> 사번,이름,직종,입사일,부서코드,부서명
--     						  |------EMP------|---DEPT---|
-- 이처럼 하나의 테이블에 있는 것 처럼 결과를 얻기 위해 여러개의 테이블 간 기본키와 외래키의 연결을 이용하여 JOIN을 사용할 때 가능하다.
SELECT * FROM DEPT;

-- 기본키 : 중복불가,NULL불가
-- 외래키 : 중복가능,NULL불가

SELECT E.EMPNO,E.ENAME,JOB,E.HIREDATE,D.DEPTNO,D.DNAME
FROM (EMP E INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO);
-- JOIN의 종류
--  1) INNERJOIN : 교집함
SELECT * FROM EMP INNER JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO;

-- 각 부서별 도시 명을 출력하자!
-- 부서코드, 부서명, 도시코드, 도시명 순으로 출력
-- |----DEPT---|---LOCATIONS---|
SELECT D.DEPTNO,D.DNAME,L.LOC_CODE,L.CITY FROM DEPT D INNER JOIN LOCATIONS L ON D.LOC_CODE = L.LOC_CODE;

-- 문제) 각 테이블 간 연결하여 각 사원들이 누가 어떤 도시에 있는 부서에서 근무하는지 출력하자/사번,이름,직종,입사일,부서코드,부서명,도시명
SELECT E.EMPNO,E.ENAME,E.JOB,E.HIREDATE,D.DEPTNO,D.DNAME,L.CITY 
FROM (EMP E INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO) INNER JOIN LOCATIONS L ON D.LOC_CODE = L.LOC_CODE;
SELECT E.EMPNO,E.ENAME,E.JOB,E.HIREDATE,D.DEPTNO,D.DNAME,L.CITY 
FROM EMP E INNER JOIN DEPT D INNER JOIN LOCATIONS L ON E.DEPTNO = D.DEPTNO AND D.LOC_CODE = L.LOC_CODE;

-- 위는 조인된 테이블들끼리 참조되는 동일한 자원들만 보여준다. 
-- 그래서 사번이 1000번인 이도라는 사원의 DEPTNO값을 NULL처리하고 다시 실행하면 결과로 포함되지 않는다.
-- 때에 따라 이도 같은 자원들도 결과로 포함시키고 싶을 때가 있다.
-- 이 때 사용하는것이 바로 LEFT JOIN OR RIGHT JOIN 즉 OUTER JOIN이다.

SELECT * FROM EMP;
-- LEFT JOIN
--  왼쪽 테이블의 자원들을 연결성을 고려하지 않고 모두 출력하고 오른쪽 테이블의 자원은 연결되어 일치하는 자원들만 출력된다.
SELECT E.EMPNO,E.ENAME,E.JOB,E.HIREDATE,D.DEPTNO,D.DNAME FROM EMP E LEFT OUTER JOIN DEPT D ON E.DEPTNO = D.DEPTNO;
SELECT E.EMPNO,E.ENAME,E.JOB,E.HIREDATE,D.DEPTNO,D.DNAME FROM EMP E RIGHT OUTER JOIN DEPT D ON E.DEPTNO = D.DEPTNO;

-- 현재 사원들과 부서간의 연결에서 부서는 존재하지만 근무하는 구성원이 없는 부서가 무엇인지 알아내자
SELECT E.*,D.DEPTNO,D.DNAME FROM EMP E RIGHT OUTER JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.DEPTNO IS NULL;

-- 문제) EMP테이블에서 직종이 'ANALYST'인 사원들의 정보를 사번,이름,직종,급여,부서명,도시코드 순으로 출력
SELECT E.EMPNO,E.ENAME,E.JOB,D.DNAME,D.LOC_CODE FROM EMP E LEFT OUTER JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.JOB = 'ANALYST';
SELECT E.EMPNO,E.ENAME,E.JOB,D.DNAME,D.LOC_CODE FROM (SELECT * FROM EMP WHERE JOB='ANALYST')AS E LEFT OUTER JOIN DEPT D ON E.DEPTNO = D.DEPTNO;
SELECT E.EMPNO,E.ENAME,E.JOB,D.DNAME,D.LOC_CODE,L.CITY
FROM (SELECT * FROM EMP WHERE JOB='ANALYST')AS E LEFT OUTER JOIN DEPT D ON E.DEPTNO = D.DEPTNO LEFT OUTER JOIN LOCATIONS L ON D.LOC_CODE = L.LOC_CODE;

-- 문제) DALLAS에서 근무하는 사원들의 정보를 사번,이름,직종,입사일,부서코드,도시명 순으로 출력
SELECT E.EMPNO, E.ENAME, E.JOB, E.HIREDATE, D.DEPTNO,L.CITY
FROM (SELECT * FROM LOCATIONS WHERE CITY = 'DALLAS') L 
INNER JOIN DEPT D ON L.LOC_CODE = D.LOC_CODE
INNER JOIN EMP E ON E.DEPTNO = D.DEPTNO;

SELECT E.EMPNO, E.ENAME, E.JOB, E.HIREDATE, D.DEPTNO,L.CITY
FROM (SELECT * FROM LOCATIONS WHERE CITY = 'DALLAS') L 
INNER JOIN DEPT D INNER JOIN EMP E
ON L.LOC_CODE = D.LOC_CODE AND E.DEPTNO = D.DEPTNO;

-- 문제)각 사원들의 관리자(mgr)이 누구인지를 알아내어 사번,이름,관리자 사번,관리자 명 순으로 출력하시오
SELECT E.EMPNO,E.ENAME,E.MGR AS MAGERNUMBER,E2.ENAME AS MANAGER FROM EMP E INNER JOIN EMP E2 ON E.MGR = E2.EMPNO;
