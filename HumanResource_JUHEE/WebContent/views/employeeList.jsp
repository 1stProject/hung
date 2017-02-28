<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <meta charset="UTF-8">
    <title>직원목록</title>
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
    <h2 class="page-title">직원목록</h2>
    <div class="contents">
        <table border="1">
            <colgroup>
                <col width="90">
                <col width="*">
                <col width="*">
                <col width="*">
            </colgroup>
            <thead>
            <tr>
                <th>번호</th>
                <th>사번</th>
                <th>이름</th>
                <th>소속</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
            	<c:when test="${deptList eq null || empty deptList}">
            		<tr>
            			<td colspan ="4"></td></tr>
            	</c:when>
            	<c:otherwise>
            		<c:forEach items="${deptList }" var="dept">
            			
              			<c:forEach items="${dept.employees }" var="emp" varStatus="sts">
              				<c:set var="count" value="${count + 1 }"/>
            				<tr>
            					<td>${count }</td>
            					<td>${emp.no }</td>
            					<td>${emp.name }</td>
            					<c:choose>
            						<c:when test="${dept.name eq 'null'}">
            							<td><a href="${ctx }/employee/assignDept.do?empNo=${emp.no}">부서배정</a></td>
            						</c:when>
            						<c:otherwise>
            							<td><a href="${ctx }/dept/detail.do?deptNo=${dept.no}">${dept.name }</a></td>
            						</c:otherwise>
            					</c:choose>
            					</tr>
            			</c:forEach>          			
            		</c:forEach>

            	</c:otherwise>
            </c:choose>
             </tbody>
        </table>
    </div>
</div>
<footer>
		<%@ include file="footer.jspf"%>
</footer>
</body>
</html>








