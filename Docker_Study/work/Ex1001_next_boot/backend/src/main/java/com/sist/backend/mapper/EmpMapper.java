package com.sist.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.sist.backend.vo.EmpVO;

@Mapper
public interface EmpMapper {
    List<EmpVO> all();
}
