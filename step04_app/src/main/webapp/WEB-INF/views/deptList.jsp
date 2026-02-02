<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
</head>
<body>

    <h1>부서 정보 리스트 (Real DB Data)</h1>
    
    <p>
        <strong>${sessionScope.loginUser.ename}</strong> 님 환영합니다. 
    </p>
    <hr>

    <table border="1" width="500">
        <thead>
            <tr style="background-color: #eee;">
                <th>부서번호</th>
                <th>부서명</th>
                <th>지역</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dept" items="${deptList}">
                <tr>
                    <td align="center">${dept.deptno}</td>
                    <td align="center">${dept.dname}</td>
                    <td align="center">${dept.loc}</td>
                </tr>
            </c:forEach>
            
            <c:if test="${empty deptList}">
                <tr>
                    <td colspan="3" align="center">데이터가 없습니다.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <br>
    <a href="/">[메인으로 돌아가기]</a>
    &nbsp;&nbsp;
    <a href="/logout">[로그아웃]</a>

</body>
</html>