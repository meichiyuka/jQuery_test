<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <jsp:include page="header.jsp" flush="true" />
<head>
<meta charset="UTF-8">
<title>TopPeage</title>
<link rel = "stylesheet" href = "top.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>

<body>

	<%
	request.setCharacterEncoding("UTF8");
	//usernameを受け取る
	String user_name = (String)request.getAttribute("user_name");
	%>

	
	<form action="login.jsp" method = "POST" class = "logoutBtn">
	<p><input type = "submit" value ="logout" class = "logout"></p>
	</form>
	
		<p class="nav-open">メニュー</p>
	
	<div class = "select">
		<ul class = "menu">
			<li>
				<form action = "./createList.jsp"  method = "POST" class = "create">
				<p><input type = "submit" value = "問題と答えを登録する >" id = "btn"></p>
				</form>
			</li>
	
			<li>
				<form action = "./Questions"  method = "POST" class = "questions">
				<p><input type = "submit" value = "問題と答えを確認する >" id = "btn"></p>
				</form>
			</li>
				
			<li>
				<form action="./IndicateTest" method = "POST" class = "doTest">
				<p><button type="submit" name="user_name" value="<%=user_name%>" id = "btn">テストをする ></button></p>
				</form>
			</li>
	
			<li>
				<form action="./Histories" method = "POST" class = "result">
				<p><button type = "submit" name="user_name" value="<%=user_name%>" id = "btn">過去の採点結果を見る ></button></p>
				</form>
			</li>
		</ul>
	</div>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src = "top.js"></script>
</body>

</html>