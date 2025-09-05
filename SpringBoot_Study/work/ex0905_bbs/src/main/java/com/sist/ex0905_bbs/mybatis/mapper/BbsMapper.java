package com.sist.ex0905_bbs.mybatis.mapper;

import com.sist.ex0905_bbs.mybatis.vo.BbsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsMapper {
    List<BbsVO> total();
    List<BbsVO> search(String type,String value);
}
