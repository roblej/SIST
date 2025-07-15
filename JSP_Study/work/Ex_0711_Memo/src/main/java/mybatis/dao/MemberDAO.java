package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.MemVO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
    public static MemVO login(String u_id, String u_pw) {
        Map<String,String> map = new HashMap<>();
        map.put("u_id", u_id);
        map.put("u_pw", u_pw);

        SqlSession ss = FactoryService.getFactory().openSession();
        MemVO mvo = ss.selectOne("member.login", map);
        ss.close();
        return mvo;
    }
}
