<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <meta charset="UTF-8">
    <title>부서등록</title>
    <link rel="stylesheet" href="${ctx }/style/css/reset.css">
    <link rel="stylesheet" href="${ctx }/style/css/style.css">
<body>
<header>
		<%@ include file="header.jspf"%>
</header>
<nav>
		<%@ include file="sideMenu.jspf"%>
</nav>
<div class="contents-wrap">
    <h2 class="page-title">부서등록</h2>
    <div class="contents">
        <form action="${ctx }/dept/create.do" method="post">
            <div>
                <label>부서번호 : </label>
                <input type="text" name="deptNo" maxlength="2">
            </div>
            <div>
                <label>부서이름 : </label>
                <input type="text" name="deptName">
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