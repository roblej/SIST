package com.sist.ex0910_jpa2.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.ex0910_jpa2.store.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {

    //검색된 데이터가 없을 떄 null이 아닌 Optional.empty()를 반환
    //그러므로 값이 없을 때 보다 안전하게 처리된다.

    Optional<Emp> findByEmpno(Long empno); // 사번검색
    List<Emp> findByDeptno(Long deptno); // 부서번호검색

    // @Query어노테이션은 Spring Data JPA에서 메서드에 직접 쿼리문을 작성할 수 있게 해주는 기능입니다.
    // nativeQuery = true 속성은 해당 쿼리가 JPQL이 아닌 순수 SQL 쿼리임을 나타냅니다.
    // 즉, 데이터베이스에 직접 실행되는 SQL 문법을 사용한다는 의미
    @Query(value = "select * from emp where job like concat('%', ?1, '%') and deptno = :deptno", nativeQuery = true)
    List<Emp> findByJobLikeAndDeptno(String job, Long deptno); // 부서번호와 직종검색

    List<Emp> findByDeptnoAndJobContaining(Long deptno, String job);
    List<Emp> findByEnameStartingWith(String ename);

    //문제 : 급여가 입력값 이하인 사원들의 정보를 입사일이 (hiredate)이 최근순으로 출력하기 위한 repository의 힘수를 작성
    List<Emp> findBySalLessThanEqualOrderByHiredateDesc(BigDecimal sal);
}
