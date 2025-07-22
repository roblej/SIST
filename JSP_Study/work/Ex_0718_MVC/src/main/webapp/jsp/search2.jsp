<%@ page import="mybatis.vo.EmpVO" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONArray" %>
<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%--MIME TYPE --%>
<%
    Object obj = request.getAttribute("ar");
    if (obj != null) {
        EmpVO[] list = (EmpVO[]) obj;
        JSONObject jsonList = new JSONObject();
        JSONArray itemList = new JSONArray();
        int i=0;
        for (EmpVO vo : list) {
        //자바스크립트에서 인식ㄱ할 수 있또록 JSON표기법을 구현하자
            JSONObject json = new JSONObject(); // {키1:"값1"} <- JSON객체
            json.put("empno", vo.getEmpno());
            json.put("ename", vo.getEname());
            json.put("job", vo.getJob());
            json.put("sal", vo.getSal());
            json.put("hiredate", vo.getHiredate());
            json.put("deptno", vo.getDeptno());
            itemList.put(json);
    }
        jsonList.put("items",itemList);//{items:[{empno = ~, ename : ~, },{empno = ~, ename : ~, }]}
        out.println(jsonList);
}
    %>