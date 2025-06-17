package am.client;

import am.vo.DeptVO;
import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Reader r = Resources.getResourceAsReader("am/config/conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
        r.close();
        //----------------한번만수행------------------------

        SqlSession ss = factory.openSession();
        List<DeptVO> list = ss.selectList("dept.all");
        for (DeptVO vo : list) {
            System.out.printf("%s,%s [%s]\r\n", vo.getDeptno(), vo.getDname(),vo.getList().size());
            if(vo.getList()!=null){
                for(EmpVO emp : vo.getList()){
                    System.out.printf("\t -> %s, %s, %s\r\n",
                            emp.getEmpno(), emp.getEname(), emp.getJob());

                }//for
            }//if
        }//for
    }//main
}//class
