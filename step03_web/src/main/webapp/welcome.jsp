<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% System.out.println("welcome.jsp 호출 확인"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	세션 데이터? -${sessionScope.id }- <br>
	날이 춥지만 공기가 맑아서 좋다<br>
	<!-- http://ip:port/fisa/welcome.jsp
		로그아웃 버튼 클릭: 세션 무효화 처리 후 welcome.jsp에서 id값 삭제된 것 확인
		controller의 logout 기능의 메소드 호출
		http://ip:port/fisa/ce/logout
	 -->
	 
	 <button onclick="location.href='ce/logout'">로그아웃</button>
</body>
</html>