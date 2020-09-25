<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-06-20
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
    <script type="text/javascript">

        $(function () {

            $(".deleteCss").click(function () {
                var action = $(".deleteCss").attr("href");
                $("#deleteForm").attr("action", action);
                $("#deleteForm").submit();
                return false;
            });
        });

    </script>
</head>
<body>

    <h1>${MESSAGE}</h1>
    <table border="1">
        <tr>
            <td>用户名</td>
            <td>邮箱</td>
            <td>所在班级</td>
            <td>性别</td>
            <td><a>详情</a></td>
            <td><a>删除</a></td>
        </tr>
        <c:if test="${userTabList != null && userTabList.size() > 0}">
            <c:forEach items="${userTabList}" var="user">
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.userMail}</td>
                    <td>${user.classTab.className}</td>
                    <td>${user.gender}</td>
                    <td><a href="${pageContext.request.contextPath}/doGetUserInfoById/${user.userId}">详情</a></td>
                    <td><a class="deleteCss" href="${pageContext.request.contextPath}/doDelUserInfoById/${user.userId}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <div><a href="${pageContext.request.contextPath}/doInitIncrUserInfo">添加新用户</a></div>
    <form:form id="deleteForm" method="post" action="">
        <input type="hidden" name="_method" value="DELETE" />
    </form:form>
</body>
</html>
