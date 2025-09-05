package com.sist.ex0905_dept.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Getter
@Mapper
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
    private String deptno,dname,loc_code;
}
