<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-06-22
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增用户信息</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/doIncrUserInfo" method="post" modelAttribute="userTab">
    <table border="1">
        <tr><td>姓名</td><td><form:input path="userName"/></td></tr>
        <tr><td>邮箱</td><td><form:input path="userMail"/></td></tr>
        <tr><td>性别</td><td><form:input path="gender"/></td></tr>
        <tr><td>年级</td><td><form:select path="classId" items="${requestScope.classTabList}" itemValue="classId" itemLabel="className"/> </td></tr>
        <tr><td colspan="2"><input type="submit" value="save_submit"/></td></tr>
    </table>
</form:form>


</body>
</html>
