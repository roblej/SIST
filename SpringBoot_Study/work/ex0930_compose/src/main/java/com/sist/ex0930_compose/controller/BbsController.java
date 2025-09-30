package com.sist.ex0930_compose.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0930_compose.service.BbsService;
import com.sist.ex0930_compose.service.CommService;
import com.sist.ex0930_compose.util.Paging;
import com.sist.ex0930_compose.vo.BbsVO;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/board")
public class BbsController {
    @Autowired
    private BbsService bbsService;

    @Autowired
    private CommService commService;

    private int numPerPage = 7;
    private int pagePerBlock = 5;

    @RequestMapping("/list")
    public Map<String, Object> list(@RequestParam ("bname") String bname,String searchType,String searchValue,String cPage) {
        int nowPage = 1;
        if(cPage !=null){
            nowPage = Integer.parseInt(cPage);
        }
        //bname이 무조건 인자로 받기로 되어있지만 공백일 때는 기본값 "BBS"로 설정
        if(bname == null || bname.trim().equals("")){
            bname = "BBS";
        }
        //페이징 기법을 위해 총 게시물 수를 알아내야 한다.
        int totalCount = bbsService.totalCount(bname, searchType, searchValue);

        //페이징 기법
        Paging paging = new Paging(numPerPage, pagePerBlock);
        paging.setTotalCount(totalCount);
        paging.setNowPage(nowPage); // totalCount 설정 후 다시 호출하여 begin, end 값 계산

        //게시물 목록을 조회
        List<BbsVO> list = bbsService.list(bname, paging.getBegin(), paging.getEnd(), searchType, searchValue);

        //게시물 목록을 반환
        Map<String, Object> map = new HashMap<>();
        map.put("ar", list);
        map.put("bname", bname);
        map.put("nowPage", nowPage);
        map.put("totalPage", paging.getTotalPage());
        map.put("totalCount", totalCount);
        map.put("length", list.size());
        return map;
    }

    @RequestMapping("/getBbs")
    public Map<String, Object> getBbs(@RequestParam ("b_idx") String b_idx) {
        Map<String, Object> map = new HashMap<>();
        BbsVO bbsVO = bbsService.getBbs(b_idx);
        map.put("bbsVO", bbsVO);
        return map;
    }

    @PostMapping("/add")
    public Map<String, Object> addBbs(@RequestBody BbsVO vo) {
        Map<String, Object> map = new HashMap<>();
        //첨부파일처리

        int cnt = bbsService.add(vo);
        map.put("cnt", cnt);
        return map;
    }


}
