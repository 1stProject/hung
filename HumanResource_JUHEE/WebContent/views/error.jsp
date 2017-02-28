<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <meta charset="utf-8">
    <title>인사관리시스템 - 오류발생 로그인</title>
    <link rel="stylesheet" href="${ctx }/style/css/reset.css">
    <link rel="stylesheet" href="${ctx }/style/css/style.css">
</head>
<body>
<div class="error-wrap">
    <h2>
        <img src="http://edu.kosta.or.kr/style/img/kocaslogo.gif" alt="kosta logo">
    </h2>
    <div class="contents">
        <div class="notice_error">
            <p class="error-title">${pageContext.exception.message }</p>
            <span class="img_notice ico_error"></span>
            <p>오류메시지</p>
            <p class="desc_error">
            	<c:forEach items="${pageContext.exception.stackTrace }" var="cause">
            	${ cause}
            	</c:forEach>
            </p>
            <span class="screen_out"><a href="${ctx }/views/menu.jsp">인사관리시스템 첫 화면</a></span>
        </div>
    </div>
    <footer>
		<%@ include file="footer.jspf"%>
    </footer>
</div>
</body>
</html>
