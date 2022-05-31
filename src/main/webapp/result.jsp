<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <jsp:include page="header.jsp" flush="true" />
<head>
<meta charset="UTF-8">
<title>result</title>
<link rel = "stylesheet" href = "result.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>

<body>

	<%
	request.setCharacterEncoding("UTF8");
	//usernameを受け取る
	String user_name = (String)request.getAttribute("user_name");
	
	//問題数を受け取る
	double questions_number = (double)request.getAttribute("questions_number");
	
	//正解数を受け取る
	double answers_number = (double)request.getAttribute("answers_number");
	
	//正解数を受け取る
	double score = (double)request.getAttribute("score");
	%>

	<div class = "slideLeft">
	<h3>テスト結果</h3>
	</div>
	
	<div class = "slideRight">
	<p><%=user_name %>さん</p>
	<p><%=Math.round(questions_number) %>問中<%=Math.round(answers_number) %>問正解です</p>
	<p><%=Math.round(score) %>点でした</p>
	
	<p><span id = "time"></span></p>
	</div>
	
<script src="result.js"></script>	
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</body>
</html>