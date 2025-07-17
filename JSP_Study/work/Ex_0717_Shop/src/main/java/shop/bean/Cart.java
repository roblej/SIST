package shop.bean;

import mybatis.vo.ProductVO;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    /*
        카트(장바구니)의 기능 분석
            1. 제품(productVO)을 저장할 수 있는 list 공간이 필요
            2. 1에서 제품을 검색하는 기능(저장할 때도 필요한 기능)
            3. 1에 제품을 저장하는 기능
            4. 1에 제품을 삭제하는 기능
            5. 2에서 검색된 제품의 수량을 변경하는 기능
            6. 1에 저장된 제품의 총 가격을 계산하는 기능
            7. 1에 저장된 모든 제품들을 배열로 반환하는 기능

        위 분석에 따른 장바구니의 속성(멤버변수)
            -List<ProductVO>
            int . long -> totalPrice : 계산되는 총액

        위 기능 분석을 바탕으로 장바구니 기능(멤버메소드) 설계
            searchProduct : 제품검색
            addProduct : 제품추가(저장)
            deleteProduct : 제품삭제
            changeCount : 제품수량변경
            getList : 장바구니에 저장된 제품들을 배열로 반환

    */
    private List<ProductVO> list; // 장바구니에 저장된 제품 목록
    private long totalPrice; // 장바구니에 저장된 제품들의 총액

    public Cart() { // 생성자 - usebean 정의시 자동 호출
        list = new ArrayList<>();
    }

    public ProductVO searchProduct(String p_num) {
        ProductVO vo = null;
        for (ProductVO pvo : list) {
            if (pvo.getP_num().equals(p_num)) {
                vo = pvo; // 검색된 제품을 vo에 저장
                break; // 검색된 제품이 있으면 반복문 종료
            }
        }
        return vo; // 검색된 제품이 없으면 null 반환
    }

    //장바구니에 있는 모든 제품들을 배열로 반환하는 기능!
    public ProductVO[] getList() {
        ProductVO[] ar = null;

        //리스트가 비어있을떄는 하지 말아야한다.
        if (!list.isEmpty()) {
            ar = new ProductVO[list.size()];
            list.toArray(ar); // 리스트를 배열로 변환
        }

        return ar;
    }

    //p_list가 실제 마트의 진열대와 같다. 이 진열대에 제품을 가져와서 장바구니에 저장
    public void addProduct(ShopBean sb, String pnum) {
        //가져온 제품이 장바구니에 이미ㅣ 저장되었는지? 확인하고자
        ProductVO vo = searchProduct(pnum); // 제품 검색

        if (vo != null) { //vo가 null이 아니면 장바구니에 이미 저장된 제품
            //수량만 1 증가시킨다
            int q = vo.getQuant();
            vo.setQuant(q + 1);
            return;
        }
    // 장바구니에 저장된 제품이 없다면 새로 추가
    // 인자로 넘어온 pnum을 ShopBean에서 검색하여 ㅎ대ㅏㅇ 제품(vo)를 얻어낸다
        vo = sb.getProduct(pnum);
        vo.setQuant(1);
        list.add(vo);
    }
    //장바구니에서 특정 제품을 삭제하는 기능
    public boolean delProduct(String pnum) {
        boolean value = false; // 삭제 여부를 저장할 변수
        //삭제하기 전에 장바구니에서 검색하자
        ProductVO vo = searchProduct(pnum);
        if (vo != null) { // 검색된 제품이 있다면
            list.remove(vo); // 장바구니에서 삭제
            value = true; // 삭제 성공
        }
        return  value;
    }
    //장바구니에 특정 제품을 검색한 후 수량만 변경하는 기능
    public void changeCount(String pnum, int q) {
        //장바구니에서 제품을 검색
        ProductVO vo = searchProduct(pnum);
        if (vo != null) { // 검색된 제품이 있다면
            vo.setQuant(q); // 수량 변경
        }
    }

}
