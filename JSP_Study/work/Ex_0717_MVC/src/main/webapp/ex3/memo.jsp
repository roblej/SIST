<%@ page import="mybatis.vo.MemoVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #table{
            width: 600px;
            border-collapse: collapse;
        }
        #table th, #table td{
            border: 1px solid black;
            padding: 5px;

        }
    </style>
</head>
<body>
<div id="wrap">
    <header><h2>메모목록</h2></header>
    <article>
        <table id="table">
            <caption>메모목록</caption>
            <thead>
            <tr>
                <th>Idx</th>
                <th>writer</th>
                <th>content</th>
                <th>date</th>
            </tr>
            </thead>
            <tbody>
            <%
                Object obj = request.getAttribute("memo");
                MemoVO[] ar = null;
                if(obj !=null){
                    ar = (MemoVO[]) obj;
                    for(MemoVO vo : ar){
            %>
            <tr>
                <td><%=vo.getIdx()%></td>
                <td><%=vo.getWriter()%></td>
                <td><%=vo.getContent()%></td>
                <td style="width: 80px;"><%=vo.getReg_date()%></td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </article>
</div>
</body>
</html>
