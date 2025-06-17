package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.DeptVO;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
        r.close();
        // 한번만 수행

        SqlSession ss = factory.openSession();
        List<DeptVO> lvo = ss.selectList("dept.all");
        for(DeptVO list : lvo){
            System.out.printf("%s %s %s\r\n",
                    list.getDeptno(), list.getDname(),list.getLvo().getCity());
        }
    }
}
