package am.client;

import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) {
        try {
            // 1) conf.xml과 연결되는 스트림
            Reader r = Resources.getResourceAsReader("am/config/conf.xml");

            // 2) SqlSessionFactory 생성
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // 3) 사용된 스트림 닫기
            r.close();
            // 한번만 수행하는 부분 ------------------------------------------------

            // 4) Sql문을 호출하기 위해 SqlSession 생성
            SqlSession ss = factory.openSession();
            Map<String,String> map = new HashMap<>();
//            map.put("no",null);//no라는 키가 있어도 null값이 들어가면 mybatis에서는 없는 것으로 인식
            map.put("deptno", "10"); //no라는 키가 있어야 mybatis에서 인식함
            map.put("job", "dev");
            List<EmpVO> list = ss.selectList("emp.search_dept5", map);
            System.out.println("사원수: " + list.size());


            ss.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
