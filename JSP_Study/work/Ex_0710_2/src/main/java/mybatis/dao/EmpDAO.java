package mybatis.dao;

import mybatis.vo.EmpVO;
import mybatis.vo.MemVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO {
    private static SqlSessionFactory factory;

    //static 초기화 - 가장 빠르게 인식되어 1번 움직여서 static변수들을 초기화한다.
    static{
        try{
            //Mybatis 준비 ------------------------------------------------------
            Reader r = Resources.getResourceAsReader("mybatis/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
            //------------------------------------------------------------------
        }catch(Exception e){

        }
    }

    //전체보기 기능
    public static EmpVO[] getAll(){
        EmpVO[] ar = null;
        SqlSession ss = factory.openSession();
        List<EmpVO> list = ss.selectList("emp.all");
        //list의 size 크기만큼 배열의 크기를 지정
        ar = new EmpVO[list.size()];
        int i=0;
        /*초보자!!
        for(EmpVO vo:list){
            ar[i++]=vo;
        }
        */
        ss.close();
        list.toArray(ar); //list에 있는 모든 요소가 ar에 복사됨
        return ar;
    }
    // 사번
    public static EmpVO getEmp(String empno){
        SqlSession ss = factory.openSession();
        EmpVO vo = ss.selectOne("emp.get_emp", empno);
        ss.close();
        return vo;
    }

    // 동적 쿼리를 사용한 검색 기능
    public  static EmpVO[] search(String searchType, String searchValue){
        EmpVO[] ar = null;
        SqlSession ss = factory.openSession();
        Map<String,String> map = new HashMap<>();
        map.put("searchType", searchType);
        map.put("searchValue", searchValue);
        List<EmpVO> list = ss.selectList("search",map);
        ar = new EmpVO[list.size()];
        list.toArray(ar);
        ss.close();
        return ar;
    }
    //로그인하는 함수
    public static MemVO login(String id, String pw){
        Map<String,String> map = new HashMap<>();
        map.put("id", id);
        map.put("pw", pw);
        SqlSession ss = factory.openSession();
        MemVO vo = ss.selectOne("mem.login", map);
        ss.close();
        return vo;
    }
}
