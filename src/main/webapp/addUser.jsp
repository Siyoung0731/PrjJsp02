<%@page import="db.DBHandler"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//http://localhost:8080/PrjJsp02/addUser.jsp
//?userid=llll	&username=saas	&email=llll12%40green.com

	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	
	// DB 저장
	DBHandler db = new DBHandler();
	db.addUser(userid, username, email);
	
	response.sendRedirect("http://localhost:8080/PrjJsp02/");
	
	System.out.println(userid);
	System.out.println(username);
	System.out.println(email);
%>
