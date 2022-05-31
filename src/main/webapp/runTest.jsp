<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <jsp:include page="header.jsp" flush="true" />
<head>
<meta charset="UTF-8">
<title>runTest</title>
<link rel = "stylesheet" href = "runTest.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>

	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>
	<%@ page import="login.QuestionsBean"%>

	<%
	request.setCharacterEncoding("UTF8");
	//問題文のリストを受け取る
	ArrayList<QuestionsBean> questionList = (ArrayList<QuestionsBean>) request.getAttribute("qList");
	//usernameを受け取る
	String user_name = (String)request.getAttribute("user_name");
	//useridを受け取る
	String user_id = (String)request.getAttribute("user_id");
	%>
	
	<div class = "topBtn">
		<!-- topに戻るボタン -->
		<form action="top.jsp" method = "POST" class = "top">
			<input type = "submit" value = "top" class = "returnTop">
		</form>
		
		<!-- logoutボタン -->
		<form action="login.jsp" method = "POST" class = "logout">
			<input type = "submit" value = "logout" class = "returnLogin">
		</form>
	</div>
	
	<form action = "RunTest" method = "POST" id="check">
	
	<%
	//問題文リストを使ってループ
	for (int i = 0; i < questionList.size(); i++) {
		//i行目のデータをqListに代入
		QuestionsBean qList = questionList.get(i);
	%>
	<div class="qBrock">
	
	

		<!--i行のデータから、問題番号を取得。テキストボックス内に表示-->
		<input type = "text" class = "questionNum" readonly = "readonly" name = "question_id[]" value = "<%=qList.getId()%>">
			<label> 	
				<!--i行のデータから、問題文を取得。テキストボックス内に表示-->
				<input type = "text" class = "questionTxt" readonly ="readonly" value = "<%=qList.getQuestion()%>">
			</label>

			<label>
			<p class = answer>回答<input type = "text" class = "AnswerTxt" name = "answer[]"></p>
			</label>
	
	
	</div>
	
	<%}%>

	</form>
	
	<div class = "bottomBtn">
		<!-- 採点ボタン -->
			<button type="submit" form="check" name = "user_name" value="<%=user_name%>" class = "scoring">採点</button>
	</div>
	
<script src = "runTest.js"></script>
</body>
</html>