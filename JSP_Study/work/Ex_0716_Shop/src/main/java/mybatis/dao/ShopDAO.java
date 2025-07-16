package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ShopDAO {

    //카테고리를 인자로 받아서 목록으로 반환하는 기능
    public static ProductVO[] getList(String category) {
        /*
         * 인자로 받은 카테고리값 중 하나를 바당서 shop_t라는 테이블로부터 해당 제품들을 검색한다
         * 이를 위해 sqlsession을 생성하고, selectList 메소드를 호출한다
         */
        SqlSession ss = FactoryService.getFactory().openSession();
        List<ProductVO> list = ss.selectList("shop.list", category);
        ss.close();
        ProductVO[] ar = null;
        if (list != null && list.size() > 0) {
            //배열을 list의 키기와 같도록 한다,
            ar = new ProductVO[list.size()];
            //list의 내용을 배열에 복사한다
            list.toArray(ar);
        }
        return ar;
    }
}

