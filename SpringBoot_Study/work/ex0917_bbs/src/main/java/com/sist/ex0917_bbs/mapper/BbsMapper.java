package com.sist.ex0917_bbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;
import com.sist.ex0917_bbs.vo.BbsVO;

@Mapper
public interface BbsMapper {
    List<BbsVO> list(String bname, int begin, int end, String searchType, String searchValue);
    int totalCount(Map<String, Object> map);
    int add(BbsVO bbsVO);
    BbsVO getBbs(String b_idx);
    int hit(String b_idx);
    int edit(Map<String, Object> map);
    int del(String b_idx);
}
