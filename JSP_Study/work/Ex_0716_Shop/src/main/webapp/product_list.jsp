<%@ page import="mybatis.vo.ProductVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="wrap">
    <header>
        <jsp:include page="./menu.jsp"/>
    </header>
    <%

    %>
    <article>
        <jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
        <jsp:setProperty name="sb" property="category"/>
        <%-- 위는 sb.setCategory(request.getParameter("category"))만 호출됨 --%>
        <%
            sb.searchProduct(); // ShopBean 클래스의 p_list가 채워짐
            //ShopBean이 가지고있는 p_list라는 배열을 얻어냄
            ProductVO[] ar = sb.getP_list();
        %>
        <table align="center" width="600" border="1"
               style="border-collapse:collapse;font-size:8pt" bordercolor="navy"
               cellpadding="4" cellspacing="0">
            <tr bgcolor="#dedede">
                <th>제품번호</th>
                <th>이미지</th>
                <th>제품명</th>
                <th>제품가격</th>
                <th>비고</th>
            </tr>
<%
if(ar!=null){
    for(ProductVO pvo : ar) {
%>
            <tr align="center">
                <td><%=pvo.getP_num()%></td>
                <td><img src="images/<%=pvo.getP_image_s()%>" width="100" height="95"></td>
                <td>
                    <a href="product_content.jsp?prod_num=<%=pvo.getP_num()%>">
                        <%=pvo.getP_name()%>
                    </a>
                </td>
                <td>
                    할인가 : <%=pvo.getP_saleprice()%>원<br>
                    <font color="red">(<%=pvo.getPercent()%>%)</font>
                </td>
                <td>
                    시중 가격 : <%=pvo.getP_price()%>원
                </td>
            </tr>
            <%
                    }
                }else{
            %>
            <tr>
                <td colspan="5" class="txt_c">해당 카테고리에 제품이 없습니다.</td>
            </tr>
            <%
                    }
            %>
        </table>
    </article>
</div>
</body>
</html>
