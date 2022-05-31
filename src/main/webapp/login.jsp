<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <jsp:include page="header.jsp" flush="true" />
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel = "stylesheet" href = "login.css">
</head>
<body>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="login.UsersBean"%>

<%//Servletのデータ受け取り
	request.setCharacterEncoding("UTF8");
	String strServlet = (String) request.getAttribute("fromServlet");%>

	<form action = "./Login2" method = "POST" class = "user_input" onsubmit="return input_check();">

	<!--jsで空欄判定した結果-->
	<p id = "error"></p>
		
	<%if(strServlet == "1"){
		out.write("ユーザー名が存在しません");
	}else if(strServlet == "3"){
		out.write("パスワードが違います");
	}%>
		<div id = "output"></div>
		<p><input type = "text" name = "ID" class = "ID" placeholder = "ユーザー名"></p>
		<p><input type="password" name = "PW" class = "PW" placeholder = "PW"></p>	
		<input type = "submit" value = "login" id = "loginButton">
	</form>	
	
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src = "login.js"></script>

</body>
</html>