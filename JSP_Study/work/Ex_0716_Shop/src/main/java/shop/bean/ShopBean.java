package shop.bean;

import mybatis.dao.ShopDAO;
import mybatis.vo.ProductVO;

public class ShopBean {
    //사용자가 선택한 category값을 저장할 곳
    private String category;

    //카테고리별로 선별된 제품들을 저장할 곳
    private ProductVO[] p_list;
    // 제품 상세보기 기능에서 받는 제품번호를 저장할 곳
    private String p_num;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductVO[] getP_list() {
        return p_list;
    }

    public void setP_list(ProductVO[] p_list) {
        this.p_list = p_list;
    }

    public String getP_num() {
        return p_num;
    }

    public void setP_num(String p_num) {
        this.p_num = p_num;
    }
    //카테고리별로 검색된 제품들을 DAO로부터 받아서 저장
    public void searchProduct(){
        p_list = ShopDAO.getList(category);
    }
    //사용자가 제품을 상세보기 할 때 제품번호(p_num)을 이용하게 된다.
    //원하는 제품을 p_list에서 검색한 후 검색된 제품이 있다면 반환
    public ProductVO getProduct(){
        ProductVO vo = null;
        //배열 p_list에서 제품번호로 검색
        for(ProductVO pvo : p_list){
            if(pvo.getP_num().equals(p_num)){
                vo = pvo; //검색된 제품을 vo에 저장
                break; //가장 가까운 반복문 탈출
            }
        }

        return vo;
    }
}
