<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <jsp:include page="header.jsp" flush="true" />
<head>
<meta charset="UTF-8">
<title>createList</title>
<link rel = "stylesheet" href = "createList.css">
</head>

<body>

<%//Servletのデータ受け取り
	request.setCharacterEncoding("UTF8");
	String strServlet = (String) request.getAttribute("fromServlet");%>

	<div class = "topBtn">
		<!-- topに戻るボタン -->
		<form action="top.jsp" method = "POST" class = "top">
			<input type = "submit" value = "top" class = "returnTop">
		</form>
		
		<!-- logoutボタン -->
		<form action="login.jsp" method = "POST" class = "logout">
			<input type = "submit" value = "logout"  class = "returnLogin">
		</form>
	</div>

	<form action="CreateList" method="POST" id="check" onsubmit="return input_check();">

	<!--jsの判定結果-->
	<p id = "error"></p>

		<div class="qBrock">

			<!--問題文を入力するテキストボックス -->
			<p>問題：</p>
			<input type="text" class ="qTxt" name="qData">
		</div>

		<!--答えを入力する欄 -->
		<table id ="answerTxt">
			<tr>
				<td></td>
			</tr>
		</table>

	</form>

	<div class="bottomBtn1">
		<!--追加ボタン -->
		<input type="button" value="追加" id="add" onclick="coladd()">
	</div>

	<div class="bottomBtn2">
		<!--確認ボタン -->
		<button type="submit" form="check" class = "checkButtom">確認</button>
	</div>

	<div class="bottomBtn3">
		<!--戻るボタン -->
		<form action="top.jsp" method = "POST">
			<input type="submit" value="戻る"  class = "returnButtom">
		</form>
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="createList.js"></script>
</body>
</html>