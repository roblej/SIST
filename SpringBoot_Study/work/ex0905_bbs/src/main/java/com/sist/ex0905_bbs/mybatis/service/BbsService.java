package com.sist.ex0905_bbs.mybatis.service;

import com.sist.ex0905_bbs.mybatis.mapper.BbsMapper;
import com.sist.ex0905_bbs.mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsService {

    @Autowired
    private BbsMapper bbsMapper;

    public BbsVO[] getAll(){
        BbsVO[] ar = null;
        List<BbsVO> list = bbsMapper.total();
        if(list!=null&&list.size()>0){
            ar = new BbsVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public BbsVO[] search(String type,String value){
        BbsVO[] ar = null;
        List<BbsVO> list = bbsMapper.search(type, value);
        if(list!=null&&list.size()>0){
            ar = new BbsVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

}
