<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<div>
		<form action="TestsessionAuth.jsp" method="get">
			ID: <input type="text" name="id"> <br /> PW: <input
				type="password" name="pw"> <br /> <input type="submit">
		</form>
	</div>
	<div>
		<%=session.getAttribute("state")%>
	</div>
	<div>
		로그아웃:
		<form
			action="<%session.invalidate();%>">
			<a> <input type="submit">
			</a>
		</form>
	</div>

</body>
</html>