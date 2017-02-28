<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <meta charset="UTF-8">
    <title>직원등록</title>
    <link rel="stylesheet" href="${ctx }/style/css/reset.css">
    <link rel="stylesheet" href="${ctx }/style/css/style.css">
</head>
<body>
<header>
		<%@ include file="header.jspf"%>
</header>
<nav>
		<%@ include file="sideMenu.jspf"%>
</nav>
<div class="contents-wrap">
    <h2 class="page-title">${department.name } 신규직원등록</h2>
    <div class="contents">

        <form action="${ctx }/employee/create.do" method="post">
        	<input type="hidden" name="deptNo" value="${department.no }">
            <div>
                <label>사번 : </label>
                <input type="text" name="empNo">
            </div>
            <div>
                <label>이름 : </label>
                <input type="text" name="empName">
            </div>
            <div class="alignRight">
                <input type="reset" value="초기화">
                <button type="submit">등록</button>
            </div>
        </form>
    </div>
</div>
<footer>
		<%@ include file="footer.jspf"%>
</footer>
</body>
</html>