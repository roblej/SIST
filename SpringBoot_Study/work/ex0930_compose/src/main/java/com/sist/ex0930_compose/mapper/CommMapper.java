package com.sist.ex0930_compose.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.sist.ex0930_compose.vo.CommVO;

@Mapper
public interface CommMapper {
    List<CommVO> commList(String b_idx);
    int addComm(CommVO commVO);
}
