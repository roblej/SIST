<%@ page import="mybatis.vo.ProductVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<link rel="stylesheet" type="text/css" href="css/product_content.css">
</head>
<body>
<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
<jsp:setProperty name="sb" property="p_num" param="prod_num"/>
<%
    ProductVO pvo = sb.getProduct();

%>
<table>
    <colgroup>
        <col width="40%">
        <col width="60%">
    </colgroup>
    <tbody>
    <tr>
        <td>제품Category</td>
        <td><%=pvo.getCategory()%></td>
    </tr>
    <tr>
        <td>제품번호</td>
        <td><%=pvo.getP_num()%></td>
    </tr>
    <tr>
        <td>제품이름</td>
        <td><%=pvo.getP_name()%></td>
    </tr>
    <tr>
        <td>제품 판매사</td>
        <td><%=pvo.getP_company()%></td>
    </tr>
    <tr>
        <td>제품가격 : <%=pvo.getP_price()%></td>
        <td>(할인가 : <%=pvo.getP_saleprice()%> )</td>
    </tr>
    <tr>
        <td colspan="2">제품설명 : <%=pvo.getP_content()%></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><img src ="images/<%=pvo.getP_image_l()%>" width="100" height="95"></td>
    </tr>
    <tr>
        <td colspan="2"></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="장바구니에 담기"
                   onclick="javascript:location.href='addProduct.jsp?p_num='"/>
            <input type="button" value="장바구니 보기"
                   onclick="javascript:location.href='cartList.jsp'"/>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
