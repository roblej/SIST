package com.sist.ex0916.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sist.ex0916.vo.MemoVO;

@Mapper
public interface MemoMapper {
    List<MemoVO> all();
    MemoVO view(String idx);
}
