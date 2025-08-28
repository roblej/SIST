package mybatis.dao;

import mybatis.vo.MemoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class MemoDAO {
    //톰캣이 구동될 때 리스너에 의해 생성된 SqlASessionTemplate이
    //자동으로 멤버변수 ss에 저장되도록 하자!
    @Autowired
    private SqlSessionTemplate ss;

    public MemoVO[] getTotal(){
        MemoVO[] ar = null;
        List<MemoVO> list = ss.selectList("memo.total");
        if(list!=null&&list.size()>0){
            ar = new MemoVO[list.size()];
            list.toArray(ar);
        }

        return ar;
    }

    //저장
    public int add(MemoVO vo){
        return ss.insert("memo.add",vo);
    }

}
