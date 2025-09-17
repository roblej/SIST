package com.sist.ex0917_bbs.service;

import org.springframework.stereotype.Service;
import com.sist.ex0917_bbs.mapper.CommMapper;
import com.sist.ex0917_bbs.vo.CommVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommService {
    @Autowired
    private CommMapper commMapper;

    public List<CommVO> commList(String b_idx) {
        return commMapper.commList(b_idx);
    }

    public int addComm(CommVO commVO) {
        return commMapper.addComm(commVO);
    }
}
