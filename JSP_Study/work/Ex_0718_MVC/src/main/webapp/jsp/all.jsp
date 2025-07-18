<%@ page import="mybatis.vo.EmpVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = request.getAttribute("ar");
    if (obj != null) {
        EmpVO[] ar = (EmpVO[]) obj;
        for (EmpVO vo : ar) {
%>
<tr>
    <td><%=vo.getEmpno()%></td>
    <td><%=vo.getEname()%></td>
    <td><%=vo.getJob()%></td>
    <td><%=vo.getSal()%></td>
    <td><%=vo.getHiredate()%></td>
    <td><%=vo.getDeptno()%></td>
</tr>
<%
        }
    } else {
%>
<tr>
    <td colspan="6">존재하지않음</td>
</tr>
<%
    }
%>