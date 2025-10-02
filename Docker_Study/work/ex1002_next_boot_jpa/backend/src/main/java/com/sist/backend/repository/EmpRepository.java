package com.sist.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.backend.store.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
    Optional<Emp> findByEmpno(Long empno);
    List<Emp> findByDeptno(Long deptno);
    List<Emp> findByJobAndDeptno(String job,Long deptno);
    @Query(value = "select * from emp where job like concat('%',?1,'%') and deptno = ?2",nativeQuery = true)
    List<Emp> findByJobLikeAndDeptno(String job,Long deptno);

    List<Emp>findByJobContainingAndDeptno(String job,Long deptno);
}
