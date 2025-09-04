package mybatis.service;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmpService implements ServiceMapper {

    @Autowired
    private EmpDAO empDAO;

    @Override
    public EmpVO[] list() {
        return empDAO.getEmp();
    }

    @Override
    public int add(EmpVO vo) {
        return empDAO.addEmp(vo);
    }

    @Override
    public EmpVO[] search(String type, String value) {
        Map<String, String> map = new HashMap<>();
        map.put("searchType", type);
        map.put("searchValue", value);

        return empDAO.search(map);
    }
}
