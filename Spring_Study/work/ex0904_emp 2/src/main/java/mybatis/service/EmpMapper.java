package mybatis.service;

import mybatis.vo.EmpVO;

public interface EmpMapper {

    EmpVO[] list();
    int add(EmpVO vo);

    EmpVO[] search(String type, String value);
}
