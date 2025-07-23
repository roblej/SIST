package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.BbsVO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BbsDAO {
    //총 게시물 수 반환
    public static int getTotalCount(String bname){
        SqlSession ss = FactoryService.getFactory().openSession();
        int cnt = ss.selectOne("bbs.totalCount", bname);
        ss.close();
        return cnt;
    }
    //목록 반환
    public static BbsVO[] getList(String bname, int begin, int end){
        BbsVO[] ar = null;

        Map<String,Object> map = new HashMap();
        map.put("bname", bname);
        map.put("begin", begin);
        map.put("end", end);

        SqlSession ss = FactoryService.getFactory().openSession();
        List<BbsVO> list = ss.selectList("bbs.list",map);
        if(list.size()>0){
            ar = list.toArray(new BbsVO[list.size()]);
        }
        return  ar;
    }
    //열기
    public static BbsVO getView(String b_idx){
        SqlSession ss = FactoryService.getFactory().openSession();
        BbsVO vo = null;
        vo = ss.selectOne("bbs.getView",b_idx);
        ss.close();

        return vo;
    }
    //저장
    public static int add(String title,String writer,String content,String fname,String oname,String ip,String bname){
        Map<String,String> map = new HashMap();
        map.put("subject",title);
        map.put("writer",writer);
        map.put("content",content);
        map.put("file_name",fname);
        map.put("ori_name",oname);
        map.put("ip",ip);
        map.put("bname",bname);

        SqlSession ss = FactoryService.getFactory().openSession();
        int cnt = ss.insert("bbs.add",map);
        if(cnt>0){
            ss.commit();
        }else ss.rollback();
        ss.close();

        return cnt;
    }

    //수정
    public static int rewrite(String b_idx,String title,String content,String fname,String oname){
        int cnt = 0;
        SqlSession ss = FactoryService.getFactory().openSession();
        Map<String,String> map = new HashMap();
        map.put("b_idx",b_idx);
        map.put("subject",title);
        map.put("content",content);
        map.put("file_name",fname);
        map.put("ori_name",oname);
        cnt = ss.update("bbs.rewrite",map);
        if(cnt>0){
            ss.commit();
        } else ss.rollback();
        ss.close();

        return  cnt;
    }
    //삭제
    public static int delBbs(String b_idx){
        SqlSession ss = FactoryService.getFactory().openSession();
        int cnt = ss.delete("bbs.del",b_idx);
        if(cnt>0){
            ss.commit();
        }else ss.rollback();
        ss.close();

        return cnt;
    }
    //조회수
    public static int hit(String b_idx){
        SqlSession ss = FactoryService.getFactory().openSession();
        int cnt = ss.update("bbs.hit",b_idx);
        if(cnt>0){
            ss.commit();
        }else ss.rollback();
        ss.close();

        return cnt;
    }

}
