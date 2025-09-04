package mybatis.service;

import mybatis.dao.BbsDAO;
import mybatis.dao.EmpDAO;
import mybatis.vo.BbsVO;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ServiceMapper {

    EmpVO[] list();
    int add(EmpVO vo);

    EmpVO[] search(String type, String value);

}
