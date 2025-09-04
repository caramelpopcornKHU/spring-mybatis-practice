<%@page import="java.net.http.HttpRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@ page import="java.util.Date" %>    
<%@ page import="java.text.SimpleDateFormat" %>    

<%
	// 세션의 유효시간
	
	session.setMaxInactiveInterval(10);

	Date creationTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	creationTime.setTime(session.getCreationTime());
	
	Date lastAccessedTime = new Date();
	lastAccessedTime.setTime(session.getLastAccessedTime());
			
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 확인</title>
</head>
<body>

<div>

세션: <%= session.getId() %> <br/>
최초생성 시간: <%= formatter.format(creationTime) %> <br/>
마지막 접근 시간: <%= formatter.format(lastAccessedTime) %> <br/>
</div>

</body>
</html>