<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String data = request.getParameter("data");

	session.setAttribute("saveData", data); //세션에 저장
	
	System.out.println("sessionSave.jsp -> data:" + session.getAttribute("saveData"));
	response.sendRedirect("sessionInfo.jsp");

%>