package com.sist.ex0901_json;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
public class EmpControl {

    @Autowired
    private EmpDAO empDAO;

    @RequestMapping(value = "empAll",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> empAll(){
        Map<String,Object> map = new HashMap<>();
        EmpVO[] ar = empDAO.getAll();
        if(ar!=null&&ar.length>0){
        map.put("ar",ar);
        map.put("length",ar.length);
        }
        return map;
    }
}
