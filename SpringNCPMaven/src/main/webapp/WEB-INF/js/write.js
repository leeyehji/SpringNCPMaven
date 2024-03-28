$(function(){
	//입력
	$('#writeBtn').click(function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val() == '')
			$('#nameDiv').text('이름 입력');
		else if($('#id').val() == '')
			$('#idDiv').text('아이디 입력');
		else if($('#pwd').val() == '')
			$('#pwdDiv').text('비밀번호 입력');
		else
			$.ajax({
				type: 'post',
				url: '/mini/user/write',
				data: $('#writeForm').serialize(), //변수=값&변수=값
				success: function(){
					alert('회원가입 완료');
					location.href='/mini/user/list';
				},
				error: function(e){
					console.log(e);
				}
			});
			
	});
	
	//아이디 중복 체크
	$('#id').focusout(function(){
		$('#idDiv').empty();
		
		if($('#id').val() == '')
			$('#idDiv').text('먼저 아이디 입력');
		else
			$.ajax({
				type: 'post',
				url: '/mini/user/isExistId',
				data: 'id=' + $('#id').val(), //서버로 보내는 데이터
				dataType: 'text', //서버로 받는 데이터 타입
				success: function(data){
					//alert(data);
					
					if(data == 'exist')
						$('#idDiv').html('사용 불가능').css('color', 'red');
					else if(data == 'non_exist')
						$('#idDiv').html('사용 가능').css('color', 'blue');	
				},
				error: function(e){
					console.log(e);
				}
		});
	});
});