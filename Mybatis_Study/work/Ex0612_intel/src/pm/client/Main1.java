package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.EmpVO;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Reader r = Resources.getResourceAsReader("pm/config/conf.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

        r.close();
        //--------------------------------------------

        SqlSession ss = factory.openSession();

        List<EmpVO> list = ss.selectList("emp.all");

        for(EmpVO vo : list){
            System.out.printf("%s %s %s %s\r\n",
                    vo.getEmpno(),vo.getEname(),vo.getJob(),vo.getDeptno());
        }

        ss.close();
    }
    //ㄴㅁㅇㄹㅇㄹㄴㅁㄻㄹ
}
