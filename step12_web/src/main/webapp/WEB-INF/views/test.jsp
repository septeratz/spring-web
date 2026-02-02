<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% System.out.println(1); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	jsp test <br>
	<%-- el tag는 값이 null이거나 사이즈가 0일 때 브라우저에 blank 출력
		== null / empty / not empty 비교
		String request.getParameter("id"); // web query string
		${param.id}
		
		String id = (String)request.getAttribute("id"); //request.setAttribute("id", "여기 있는 데이터를 가져옴")
		${requestScope.id}
		 --%>
	${requestScope.message }
</body>
</html>