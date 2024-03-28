$(function(){

	//id에 해당하는 데이터 가져오기
	$.ajax({
		type: 'post',
		url: '/mini/user/getUser',
		data: 'id=' + $('#id').val(),
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$('#name').val(data.name);
			$('#pwd').val(data.pwd);
		},
		error: function(e){
			console.log(e);
		}
	});
});

//취소 버튼
$('#resetBtn').click(function(){
	location.reload();
});

//수정 버튼
$('#updateBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val() == '')
		$('#nameDiv').text('이름 입력');
	else if($('#pwd').val() == '')
		$('#pwdDiv').text('비밀번호 입력');
	else
		$.ajax({
			type: 'post',
			url: '/mini/user/update',
			data: $('#updateForm').serialize(), //변수=값&변수=값
			success: function(){
				alert('회원정보 수정 완료');
				location.href = '/mini/user/list?pg=' + $('#pg').val();
			},
			error: function(e){
				console.log(e);
			}
		});
});



















