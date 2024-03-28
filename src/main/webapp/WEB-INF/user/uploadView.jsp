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
</style>
</head>
<body>
	<a href="/mini/"><img src="../image/apple.png" width="30" height="30"></a>
	<input type="hidden" id="seq" value="${seq }">

	<table border="1" frame="hsides" rules="rows">
		<tr>
			<td rowspan="3" width="200" height="200"><span id="imageSpan"></span></td>
			<td width="300">번호: ${seq }</td>
		</tr>
		
		<tr>
			<td>상품명: <spna id="imageNameSpan"></spna></td>
		</tr>
		
		<tr>
			<td>파일명: <span id="imageOriginalNameSpan"></span></td>
		</tr>
		
		<tr>
			<td colspan="2" height="100">내용:<br><span id="imageContentSpan"></span></td>
		</tr>
	</table>
	
	<div style="margin-top: 5px;">
		<input type="button" value="목록" onclick="location.href='/mini/user/uploadList'">
		<input type="button" value="수정" onclick="location.href='/mini/user/uploadUpdateForm?seq=${seq}'">
	</div>

<script type="text/javascript" src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/uploadView.js"></script>
</body>
</html>