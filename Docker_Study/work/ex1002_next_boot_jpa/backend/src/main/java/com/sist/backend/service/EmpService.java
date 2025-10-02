package com.sist.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.sist.backend.repository.EmpRepository;
import com.sist.backend.store.Emp;

@Service
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository empRepository;
    
    public Object findAll(){
        return empRepository.findAll();
    }
    public Optional<Emp> findByEmpno(Long empno){
        return empRepository.findByEmpno(empno);
    }
    public List<Emp> findByDeptno(Long deptno){
        return empRepository.findByDeptno(deptno);
    }
    public List<Emp> findByJobAndDeptno(String job,Long deptno){
        return empRepository.findByJobAndDeptno(job,deptno);
    }
    public List<Emp> findByJobLikeAndDeptno(String job,Long deptno){
        return empRepository.findByJobLikeAndDeptno(job,deptno);
    }
    public List<Emp> findByJobContainingAndDeptno(String job,Long deptno){
        return empRepository.findByJobContainingAndDeptno(job,deptno);
    }
}
