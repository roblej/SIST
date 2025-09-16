package com.sist.ex0916.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0916.mapper.MemoMapper;
import com.sist.ex0916.vo.MemoVO;

@Service
public class MemoService {
    @Autowired
    private MemoMapper memoMapper;

    public List<MemoVO> all() {
        return memoMapper.all();
    }

    public MemoVO view(String idx) {
        return memoMapper.view(idx);
    }
}