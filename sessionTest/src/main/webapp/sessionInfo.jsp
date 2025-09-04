<%@page import="java.net.http.HttpRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@ page import="java.util.Date" %>    
<%@ page import="java.text.SimpleDateFormat" %>    

<%
	Date creationTime = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	creationTime.setTime(session.getCreationTime());
	
	Date lastAccessedTime = new Date();
	lastAccessedTime.setTime(session.getLastAccessedTime());
	
	
	//session <- 기본으로 생성되어있는 객체.
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
세션에 저장된 데이터: <%=session.getAttribute("saveData")%>
</div>

</body>
</html>