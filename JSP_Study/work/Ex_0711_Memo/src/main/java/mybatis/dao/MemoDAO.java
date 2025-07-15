package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.MemoVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MemoDAO {

    public static MemoVO[] GetAll(){

        SqlSession ss = FactoryService.getFactory().openSession();
        List<MemoVO> list = ss.selectList("memo.all");
        ss.close();
        MemoVO[] ar = list.toArray(new MemoVO[list.size()]);
        return ar;
    }
    public static int Add(String content, String writer,String ip){
        MemoVO vo = new MemoVO();
        vo.setContent(content);
        vo.setWriter(writer);
        vo.setIp(ip);
        SqlSession ss = FactoryService.getFactory().openSession();
        int cnt = ss.insert("memo.add", vo);
        if(cnt>0){
            ss.commit();
        }else ss.rollback();
        ss.close();
        return cnt;
    }
}
