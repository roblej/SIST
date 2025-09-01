package mybatis.dao;

import mybatis.vo.BbsVO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BbsDAO {

    @Autowired
    private SqlSessionTemplate ss;

    //총 게시물 수 반환
    public int getTotalCount(String bname){
        return ss.selectOne("bbs.totalCount", bname);
    }

    //목록 반환
    public BbsVO[] getList(String bname, int begin, int end){
        BbsVO[] ar = null;

        Map<String,Object> map = new HashMap();
        map.put("bname", bname);
        map.put("begin", begin);
        map.put("end", end);

        List<BbsVO> list = ss.selectList("bbs.list",map);
        if(list.size()>0){
            ar = list.toArray(new BbsVO[list.size()]);
        }
        return  ar;
    }
    //열기
    public BbsVO getView(String b_idx){
        return ss.selectOne("bbs.getView",b_idx);
    }
    //저장
    public int add(String title,String writer,String content,String fname,String oname,String ip,String bname){
        Map<String,String> map = new HashMap();
        map.put("subject",title);
        map.put("writer",writer);
        map.put("content",content);
        map.put("file_name",fname);
        map.put("ori_name",oname);
        map.put("ip",ip);
        map.put("bname",bname);

        return ss.insert("bbs.add",map);
    }

    //수정
    public int rewrite(String b_idx,String title,String content,String fname,String oname,String ip){
        int cnt = 0;
        Map<String,String> map = new HashMap();
        map.put("b_idx",b_idx);
        map.put("subject",title);
        map.put("content",content);
        if(fname!=null){
        map.put("file_name",fname);
        map.put("ori_name",oname);
        }
        map.put("ip",ip);
        System.out.println("DAO");
        return  ss.update("bbs.rewrite",map);
    }
    //삭제
    public int delBbs(String b_idx){
        return ss.delete("bbs.del",b_idx);
    }
    //조회수
    public int hit(String b_idx){
        return ss.update("bbs.hit",b_idx);
    }

}
