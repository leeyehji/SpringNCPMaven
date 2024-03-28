<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}
#updateForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form id="updateForm">
	<input type="hidden" id="id" value="${id }">
	<input type="hidden" id="pg" value="${pg }">

	<a href="/mini/"><img src="../image/apple.png" width="30" height="30"></a>
	<table border="1">
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" id="name">
				<div id="nameDiv"></div>
			</td>
		</tr>
	   
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" id="id" value="${id }" readonly>
			</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pwd" id="pwd">
				<div id="pwdDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" id="updateBtn">
				<input type="button" value="삭제" id="deleteBtn">
				<input type="reset" value="취소" id="resetBtn">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/update.js"></script>
<script type="text/javascript" src="../js/delete.js"></script>
</body>
</html>












