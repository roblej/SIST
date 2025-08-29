package mybatis.dao;

import mybatis.vo.BbsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class BbsDAO {

    @Autowired
    private SqlSessionTemplate ss;

    public int add(BbsVO vo) {
        return ss.insert("bbs.add", vo);
    }

    public BbsVO[] getList(String bname, int begin, int end){
        BbsVO[] ar = null;
        Map<String, Object> map = new HashMap();
        map.put("bname", bname);
        map.put("begin", begin);
        map.put("end", end);
        List<BbsVO> list = ss.selectList("bbs.list",map);
        ar = new BbsVO[list.size()];
        list.toArray(ar);
        return ar;
    }

    public int getTotalCount(String bname) {
        return ss.selectOne("bbs.getTotalCount",bname);
    }

    public BbsVO getView(String idx) {
        return ss.selectOne("bbs.getView",idx);
    }

    public void hit(String bIdx) {
        ss.update("bbs.hit",bIdx);
    }
}
