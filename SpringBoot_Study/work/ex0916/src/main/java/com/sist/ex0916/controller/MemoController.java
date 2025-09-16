package com.sist.ex0916.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0916.service.MemoService;
import com.sist.ex0916.vo.MemoVO;

@RestController
@RequestMapping("/memo")
public class MemoController {
    @Autowired
    private MemoService memoService;

    @GetMapping("/all")
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        List<MemoVO> list = memoService.all();
        
        map.put("m_list", list);
        map.put("length", list.size());

        return map;
    }

    @GetMapping("/view")
    public Map<String, Object> getView(@RequestParam String idx) {
        Map<String, Object> map = new HashMap<>();
        MemoVO vo = memoService.view(idx);
        map.put("m_view", vo);
        return map;
    }
}
