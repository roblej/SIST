package com.sist.ex0910_jpa2.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0910_jpa2.service.EmpService;
import com.sist.ex0910_jpa2.store.Emp;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    @RequestMapping("/all")
    public Object empAll() {
        return empService.findAll();
    }

    @RequestMapping("/getEmp")
    public Optional<Emp> getEmp(@RequestParam("empno") Long empno) {
        return empService.findByEmpno(empno);
    }
    //직종과 부서번호검색을 and조건으로 검색
    @RequestMapping("/getDeptandJob")
    public List<Emp> getDeptandJob(@RequestParam("deptno") Long deptno, @RequestParam("job") String job) {
        return empService.findByDeptnoAndJobContaining(job, deptno);
    }

        @RequestMapping("/getDeptandJob2")
    public List<Emp> getDeptandJob2(@RequestParam("deptno") Long deptno, @RequestParam("job") String job) {
        return empService.findbyJobLikeAndDeptno(job, deptno);
    }
    //이름으로 시작하는 사원검색
    @RequestMapping("/getEname")
    public List<Emp> getEname(@RequestParam("ename") String ename) {
        return empService.findByEnameStartingWith(ename);
    }
    //급여가 입력값 이하인 사원들의 정보를 입사일이 (hiredate)이 최근순으로 출력
    @RequestMapping("/getSal")
    public List<Emp> getSal(@RequestParam("sal") BigDecimal sal) {
        return empService.findBySalLessThanEqualOrderByHiredateDesc(sal);
    }
}