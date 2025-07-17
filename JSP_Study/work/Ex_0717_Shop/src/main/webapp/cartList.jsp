<%@ page import="mybatis.vo.ProductVO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="wrap">
    <header>
        <jsp:include page="./menu.jsp"/>
    </header>

    <article>
        <%--
        ShopBean이라는 빈을 재사용하자!
        앞서 product_list.jsp에서 useBean으로 사용된 ShopBean을 다시 세션으로부터 가져와서
        재사용하면 ShopBean의 멤버변수인 p_list라는 배열이 채워진 상태에서
        재 사용기 가능하다. 이렇게 하기 위해서는 반드시
        pruduct_list.jsp에서 ShopBean을 useBean으로 정의하는 내용을 아래와 같이
        복사해서 붙여넣기 해야한다.
        --%>
        <jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
        <%

        %>
        <table class="table" width="600" border="1" align="center"
               style="border-collapse:collapse;font-size:8pt" cellspacing="0"
               cellpadding="4">
            <thead>
            <tr>
                <td colspan="6">:: 장바구니 내용</td>
            </tr>
            <tr bgcolor="#dedede">
                <th>제품번호</th>
                <th width="25%">제품명</th>
                <th>단가</th>
                <th>수량</th>
                <th>금액</th>
                <th>삭제</th>
            </tr>
            </thead>
            <jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
            <%
                //장바구니에 저장된 모든 제품들을 배열로 가져온다
                ProductVO[] ar = cart.getList();
                int total = 0;

                if (ar != null) {
                    for (ProductVO vo : ar) {
            %>
            <tbody>
            <tr align="center">
                <td><%=vo.getP_num()%>
                </td>
                <td><%=vo.getP_name()%>
                </td>
                <td>
                    정가:<%=vo.getP_price()%><br>
                    <font color="red">
                        세일가격: <%=vo.getP_saleprice()%>원
                    </font>
                </td>
                <td>
                    <!-- 수량 조정 폼 -->
                    <form action="changeCount.jsp" method="post">
                        <input type="hidden" name="p_num" value="<%=vo.getP_num()%>">
                        <input type="number" name="count" value="<%=vo.getQuant()%>" min="1"/>
                        <button type="button" onclick="ch(this.form)">변경</button>
                    </form>
                    <!------------------>
                </td>
                <td><%=vo.getTotalPrice()%></td>
                <td>
                    <input type="button" value="삭제"
                           style="border:1 solid black;cursor:pointer"
                           onclick="javascript:location.href='delProduct.jsp?p_num=<%=vo.getP_num()%>'">
                </td>
            </tr>
            <%
                    //총액 누적
                    total += vo.getTotalPrice();
                }
            } else {
            %>
            <tr align="center">
                <td colspan="6">
                    <b>장바구니가 비었습니다.</b>
                </td>
            </tr>
            <%
                }
            %>
            <tr>
                <td colspan="5" align="right">총 결재액 :</td>
                <td><%=total%>
                </td>
            </tr>
            </tbody>
        </table>

    </article>
</div>
<script>
    function ch(frm) {
        frm.submit()
    }
</script>
</body>
</html>
