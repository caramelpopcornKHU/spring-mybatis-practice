<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증소</title>
</head>
<body>
	<%=request.getParameter("id")%>
	<%=request.getParameter("pw")%>

	<%
	session.setAttribute("state", "login success");
	
	
	if (request.getParameter("id") == "1234" & request.getParameter("pw") == "1234") {
	session.setAttribute("state", "login success yes");
	}
	System.out.println(session.getAttribute("state"));
	response.sendRedirect("TestsessionLogin.jsp");
	%>

</body>
</html>