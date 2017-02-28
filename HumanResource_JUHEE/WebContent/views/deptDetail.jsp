<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <meta charset="UTF-8">
    <title>부서 상세정보</title>
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
    <h2 class="page-title">부서 상세조회</h2>
    <div class="contents">
        <div class="info-box">
            부서번호 : ${ department.no} <br>
            부서명 : ${department.name }
        </div>
        <table>
            <colgroup>
                <col width="90">
                <col width="*">
                <col width="*">
            </colgroup>
            <thead>
            <tr>
                <th>번호</th>
                <th>사번</th>
                <th>이름</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
            	<c:when test="${department.employees eq null || empty department.employees }">
            		<tr>
            			<td colspan="3">등록된 사원이 없습니다.</td></tr>
            	</c:when>
            	<c:otherwise>
            		<c:forEach items="${department.employees }" var="emp" varStatus="sts">
            			<tr>
            				<td>${sts.count }</td>
            				<td>${emp.no }</td>
            				<td>${emp.name }</td>
            				</tr>
            		</c:forEach>
            	</c:otherwise>
            </c:choose>
            </tbody>
        </table>
        <a href="${ctx }/employee/create.do?deptNo=${department.no }"><button>신규직원등록</button></a>
        
    </div>
</div>
<footer>
		<%@ include file="footer.jspf"%>
</footer>
</body>
</html>