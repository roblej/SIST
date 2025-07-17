<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean class="shop.bean.ShopBean" id="sb" scope="session"/>
<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>

<%
  String pnum = request.getParameter("p_num");
  if(pnum!=null)
    cart.delProduct(pnum);

  response.sendRedirect("cartList.jsp");
%>
