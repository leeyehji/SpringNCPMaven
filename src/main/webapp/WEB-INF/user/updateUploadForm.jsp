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

<form method="post" enctype="multipart/form-data" id="updateUploadForm">
	<a href="/mini/"><img src="../image/apple.png" width="30" height="30"></a>

	<input type="hidden" id="id" value="${id }">
	<table border="1">
		<tr>
			<th>상품명</th>
			<td>
				<input type="text" name="imageName" id="imageName" size="35">
				<div id="imageNameDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<textarea name="imageContent" id="imageContent" rows="10" cols="50"></textarea>
				<div id="imageContentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="file" name="img[]" multiple="multiple">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="이미지 수정" id="updateBtn">
				<input type="button" value="삭제" id="deleteBtn">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>


</body>
</html>