package com.sist.ex0910_jpa2.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0910_jpa2.repository.EmpRepository;
import com.sist.ex0910_jpa2.store.Emp;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    public List<Emp> findAll() {
        return empRepository.findAll();
    }  

    public Optional<Emp> findByEmpno(Long empno) {
        return empRepository.findByEmpno(empno);
    }

    public List<Emp> findByDeptno(Long deptno) {
        return empRepository.findByDeptno(deptno);
    }
    //like쓴거
    public List<Emp> findbyJobLikeAndDeptno(String job, Long deptno) {
        return empRepository.findByJobLikeAndDeptno(job, deptno);
    }
    public List<Emp> findByDeptnoAndJobContaining(String job, Long deptno) {
        return empRepository.findByDeptnoAndJobContaining(deptno, job);
    }
    public List<Emp> findByEnameStartingWith(String ename) {
        return empRepository.findByEnameStartingWith(ename);
    }
    public List<Emp> findBySalLessThanEqualOrderByHiredateDesc(BigDecimal sal) {
        return empRepository.findBySalLessThanEqualOrderByHiredateDesc(sal);
    }
}
