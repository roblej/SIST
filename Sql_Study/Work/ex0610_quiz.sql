-- 1. emp테이블에서 연봉을 계산하는 SELECT문장을 기술하시오(급여*보너스)
select sal*ifnull(comm,1) from 	emp;
-- 2. emp테이블에서 사번이 7521번인 사원의 직종과 같고,7844번 사원의 급여보다 많이 받는 사원들의 정보를 사번,이름,직종,급여,입사일 순으로 출력하시오. 단,서브쿼리를 활용하자
select empno,ename,job,sal,hiredate from emp where job =(select job from emp where empno = '7521') and sal >=(select sal from emp where empno='7844');
-- 3. emp테이블에서 직종이 ‘CLERK’ 또는 ‘SALESMAN’인 사원들 중 최대 급여를 구하는 SELECT문장을 기술하시오
select max(sal) from emp where job in ('salesman','clerk');
-- 4. 서브쿼리를 활용하여 emp테이블에서 사원 이름이 'SMITH'이고, 직종이 'CLERK'인사원의 급여보다 더 많이 받는 사원들의 정보를 사번,이름,직종,급여 순으로 출력해보자!.
select empno,ename,job,sal from emp where sal>(select sal from emp where ename ='smith' and job = 'clerk');
-- 5. emp테이블에서 각 부서별 인원수를 구하는 SELECT 문장을 기술하시오.(부서가 NULL인 사람도 출력하시오)
select deptno,count(*) from emp group by deptno;
-- 6. emp테이블에서 각 부서별 인원이 5명 이상인 부서의 부서코드, 인원수, 급여의 합을 구하는 SELECT 문장을 기술하시오
select deptno,count(*),sum(sal) from emp group by deptno having count(*)>5;
select deptno,sal from emp where deptno = 10;
-- 7. 각 부서별 보너스의 합을 구하여 부서코드, 인원수, 보너스의 합 순으로 정보를 출력하는 SELECT 문장을 기술하시오! (단 NULL이 출력되어서는 안된다.)
select deptno,count(*),sum(ifnull(comm,0)) from emp group by deptno;
-- 8. deptno가 20인 부서의 도시명을 알아내는 SELECT 문장을 기술하시오.
select d.deptno,l.city from (select * from dept where deptno=20) d, locations l where d.loc_code = l.loc_code;
-- 9.각 사원들의 관리자(MGR)가 누구인지를 알아내어 사번, 이름, 관리자사번(MGR),관리자 명순으로 출력 하시오!

-- 10. emp테이블에서 직종이 ‘ANALYST’인 사원들의 정보를사번, 이름, 직종, 급여, 부서명, 도시명 순으로 출력하시오
