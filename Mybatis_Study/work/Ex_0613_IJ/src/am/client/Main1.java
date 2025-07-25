package am.client;

import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Main1 {
    public static void main(String[] args) {
        try{
            //1) conf.xml과 연결되는 스트림
            Reader r = Resources.getResourceAsReader("am/config/conf.xml");

            //2) SqlSessionFactory 생성
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            //3) 사용된 스트림 닫기
            r.close();
            // 한번만 수행하는 부분 ------------------------------------------------

            //emp테이블에 저장하기 위해 EmpVO 객체를 준비
            //왜 EmpVO를 준비하는가? -> 호출학좌 하는 SQL문이 emp.add라는 mapper이다.
            //emp.add에 parameterType이 EmpVO로 되어있기 때문에

            EmpVO vo = new EmpVO();
            vo.setEmpno("1101");
            vo.setEname("창조리");
            vo.setJob("Develop");
            vo.setHiredate("2023-10-01");

            //4) Sql문을 호출하기 위해 SqlSession 생성
            SqlSession ss = factory.openSession();
            int cnt = ss.insert("emp.add", vo);
            if(cnt > 0) {
                ss.commit();
                System.out.println("저장완료");
            }else {
                ss.rollback();
                System.out.println("저장실패");
            }
            ss.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
