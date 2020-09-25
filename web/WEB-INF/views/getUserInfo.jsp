<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  UserInfoProxy: admin
  Date: 2020-06-22
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户详情</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}" method="post" modelAttribute="userInfo">
<input type="hidden" name="_method" value="PUT">
    <form:input path="userId" cssStyle="visibility: hidden"/>
<table border="1">
    <tr><td>姓名</td><td><form:input id="userName" path="userName" readonly="true" /></td></tr>
    <tr><td>邮箱</td><td><form:input id="userMail" path="userMail" readonly="true"/></td></tr>
    <tr><td>年级</td><td><form:input id="className" path="classTab.className" readonly="true"/></td></tr>
</table>
    <input id="commit" style="visibility: hidden" type="submit" value="update_commit">
</form:form>
<input id="button" type="button" style="visibility:visible;" onclick="uptchangge()" value="变更">
</body>
<script>
    function uptchangge() {
        alert("调用方法");
        alert($("#userName").val());
        $("#userName").readOnly(false);
        $("#userMail").readOnly(false);
        $("#className").readOnly(false);
        $("#commit").style.visibility = "visible";
        $("#button").style.visibility = "hidden";

    }

</script>

</html>
