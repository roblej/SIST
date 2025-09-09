package com.sist.ex0908_bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0908_bbs.mapper.BbsMapper;
import com.sist.ex0908_bbs.vo.BbsVO;

@Service
public class BbsService {
    @Autowired
    private BbsMapper bbsMapper;


    //총 게시물 수
    public int totalCount(String bname) {
        return bbsMapper.totalCount(bname);
    }

    //게시물 목록
    public BbsVO[] getBbsList(String bname, int begin, int end){
        List<BbsVO> list = bbsMapper.list(bname, begin, end);
        BbsVO[] arr = new BbsVO[list.size()];
        list.toArray(arr);
        return arr;
    }

    //게시물 추가
    public int add(BbsVO vo) {
        return bbsMapper.add(vo);
    }

    public BbsVO getBbs(String b_idx){
        return bbsMapper.getBbs(b_idx);
    }
    public int hit(String b_idx){
        return bbsMapper.hit(b_idx);
    }

    public int edit(BbsVO vo){
        return bbsMapper.edit(vo);
    }
}
    
