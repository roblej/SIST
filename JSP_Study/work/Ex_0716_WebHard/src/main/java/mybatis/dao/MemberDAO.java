package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.MemVO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class MemberDAO {

    //login.jsp에서 호출하는 로그인 함수
    public static MemVO login(String id, String pw){
        HashMap<String, String> map = new HashMap<>();
        map.put("m_id",id);
        map.put("m_pw",pw);

        //sql문을 호출하기 위해 필요한 객체 SqlSession얻기
        SqlSession ss = FactoryService.getFactory().openSession();
        MemVO mvo = ss.selectOne("member.login", map);
        ss.close();

        return mvo;
    }
    public static int registry(MemVO mvo){
        //sql문을 호출하기 위해 필요한 객체 SqlSession얻기
        SqlSession ss = FactoryService.getFactory().openSession(true);
        int result = ss.insert("member.add", mvo);
        if (result > 0) {
            ss.commit(); // 성공 시 커밋
        } else {
            ss.rollback(); // 실패 시 롤백
        }
        ss.close();

        return result;
    }
    public static boolean idCheck(String m_id) {
        SqlSession ss = FactoryService.getFactory().openSession();
        MemVO vo = ss.selectOne("member.id_check", m_id);
        ss.close();
        return (vo == null)?true:false;
    }
}
