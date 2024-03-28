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
	width: 200px;
}
#currentPaging {
	border: 1px solid #ccc;
	margin: 5px;
	padding: 5px 8px;
	color: red;
	cursor: pointer;
}
#paging {
	margin: 5px;
	padding: 5px;
	color: black;
	cursor: pointer;
}
</style>
</head>
<body>
	<input type="hidden" id="pg" value="${pg }"><br><br>
	
	<a href="/mini/"><img src="../image/apple.png" width="30" height="30"></a>
	<table border="1" frame="hsides" role="rows" id="userListTable">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		
		<!-- 동적 처리 -->
	</table>
	
	<!-- 페이징 처리 -->
	<div id="userPagingDiv" style="width: 650px; text-align: center; margin-top: 10px;">~~~</div>
	
	<script type="text/javascript" src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/list.js"></script>
	<script type="text/javascript">
		function userPaging(pg){
			location.href = "/mini/user/list?pg=" + pg;
		}
	</script>
</body>
</html>














