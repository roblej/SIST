package com.sist.ex0905_emp.mybatis.service;

import com.sist.ex0905_emp.mybatis.mapper.EmpMapper;
import com.sist.ex0905_emp.mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    public EmpVO[] getAll(){
        EmpVO[] ar = null;
        List<EmpVO> list = empMapper.all();
        if(list!=null&&list.size()>0){
        ar = new EmpVO[list.size()];
        list.toArray(ar);
        }
        return ar;
    }
}
