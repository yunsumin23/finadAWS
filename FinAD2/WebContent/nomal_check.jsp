<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
	String id = request.getParameter("id");
	String isAvailable = "true";
	if (id == null || id.trim().isEmpty()) {
		isAvailable = "check";
	}
	Connection connection = null;
	Statement statement = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://3.34.46.245:3306/project?characterEncoding=utf-8", "ysumin", "123456");
		if (connection == null) {
			throw new Exception("데이터베이스 연결 안됨");
		}
		statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select nomalUserId from project.nomal_user where nomalUserId = '" + id + "';");
		while (resultSet.next()) {
			isAvailable = "false";
		}
	} finally {
		try {
			statement.close();
		} catch (Exception ignored) {
		}

		try {
			connection.close();
		} catch (Exception ignored) {
		}
	}
	out.print(isAvailable);
%>