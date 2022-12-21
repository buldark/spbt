<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><img src="../image/img2.png" width="50" height="50" 
onclick="location.href='/'" style="cursor: pointer;"/>회원정보삭제</h3>
<hr/>

<p>
	삭제 할 아이디 입력 <input type="text" id="searchId" placeholder="아이디를 입력하세요"> 
	<input type="button" id="searchIdBtn" value="검색">
</p>
<div id="resultDiv"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="../js/delete.js"></script>
</body>
</html>