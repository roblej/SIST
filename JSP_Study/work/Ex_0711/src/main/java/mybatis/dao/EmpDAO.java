package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.EmpVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpDAO {
    //사원들을 목록으로 반환(배열[추천]?리스트?)하는 기능
    public static List<EmpVO> getAll(){
        SqlSession ss = FactoryService.getFactory().openSession();
        List<EmpVO> list = ss.selectList("emp.all");
        ss.close();
        return  list;
    }

    public static int addEmp(String empno,String ename, String job, String hiredate){
        EmpVO vo = new EmpVO();
        vo.setEmpno(empno);
        vo.setEname(ename);
        vo.setJob(job);
        vo.setHiredate(hiredate);

        SqlSession ss = FactoryService.getFactory().openSession();
        int res = ss.insert("emp.add",vo);
        if(res>0){
            ss.commit();
        }else ss.rollback();
        ss.close();
        return  res;
    }

}
