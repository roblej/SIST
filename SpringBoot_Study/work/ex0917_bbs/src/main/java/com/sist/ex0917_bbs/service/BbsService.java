package com.sist.ex0917_bbs.service;

import org.springframework.stereotype.Service;
import com.sist.ex0917_bbs.mapper.BbsMapper;
import com.sist.ex0917_bbs.vo.BbsVO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BbsService {
    @Autowired
    private BbsMapper bbsMapper;

    public List<BbsVO> list(String bname, int begin, int end, String searchType, String searchValue) {
        return bbsMapper.list(bname, begin, end, searchType, searchValue);
    }

    public int totalCount(String bname, String searchType, String searchValue) {
        // map 생성
        Map<String, Object> map = new java.util.HashMap<>();
        if(bname != null){
            map.put("bname", bname);
        }
        if(searchType != null){
            map.put("searchType", searchType);
        }
        if(searchValue != null){
            map.put("searchValue", searchValue);
        }
        map.put("searchValue", searchValue);
        return bbsMapper.totalCount(map);
    }

    public BbsVO getBbs(String b_idx) {
        return bbsMapper.getBbs(b_idx);
    }

    public int add(BbsVO bbsVO) {
        return bbsMapper.add(bbsVO);
    }

    public int hit(String b_idx) {
        return bbsMapper.hit(b_idx);
    }

    public int edit(Map<String, Object> map) {
        return bbsMapper.edit(map);
    }

    public int del(String b_idx) {
        return bbsMapper.del(b_idx);
    }
}
