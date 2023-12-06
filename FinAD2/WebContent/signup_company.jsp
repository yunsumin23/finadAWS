<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8"); // 한글 데이터 인코딩 설정
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("company_name");
	String person = request.getParameter("company_person");
	String phone = request.getParameter("company_phone");
	String email = request.getParameter("company_email");
	String number = request.getParameter("company_number");
	
	Connection connection = null;
	Statement statement = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://3.34.46.245:3306/project?characterEncoding=utf-8", "ysumin", "123456");

												
		if(connection == null) {
			throw new Exception("데이터베이스 연결 안됨<br>");
		}
		statement = connection.createStatement();
		int i = statement.executeUpdate("insert into company(companyId, password, companyName, name, telephoneNumber, eMail, licenseNumber) values ('"+  id + "','" + pw + "','" + name + "','" + person + "','" + phone + "','" + email + "','" + number + "');");
	} finally {
		try {
			statement.close();
		} catch (Exception ignored) {
			
		}
	} try {
		connection.close();
	} catch (Exception ignored) {
		
	}
	response.sendRedirect("signup_final.jsp");
%>
</body>
</html>