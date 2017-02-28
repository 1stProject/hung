<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <meta charset="UTF-8">
    <title>부서목록</title>
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
    <h2 class="page-title">부서목록</h2>
    <div class="contents">
        <table border="1">
            <colgroup>
                <col width="90">
                <col width="150">
                <col width="*">
                <col width="90">
            </colgroup>
            <thead>
            <tr>
                <th>번호</th>
                <th>부서코드</th>
                <th>부서명</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
            	<c:when test="${deptList eq null || empty deptList }">
            	<tr>
            		<td colspan="4"> 등록된 부서가 없습니다.
            		</td>
            		</tr>
            	</c:when>
            	<c:otherwise>
            	<c:forEach items="${deptList}" var="dept" varStatus="sts">
             <tr>
                <td>${sts.count }</td>
                <td>${dept.no }</td>
                <td><a href="${ctx }/dept/detail.do?deptNo=${dept.no }">${dept.name }</a></td>
                <td class="delete"><a href="${ctx }/dept/delete.do?deptNo=${dept.no }">삭제</a></td>
            </tr>           	
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








