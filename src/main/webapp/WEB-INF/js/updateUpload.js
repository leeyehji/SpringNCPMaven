$(function(){

	//id에 해당하는 데이터 가져오기
	$.ajax({
		type: 'post',
		url: '/mini/user/getUser',
		data: 'id=' + $('#id').val(),
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$('#imageName').val(data.imageName);
			$('#imageContent').val(data.imageContent);
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
	$('#imageNameDiv').empty();
	$('#imageContentDiv').empty();
	
	if($('#imageName').val() == '')
		$('#imageNameDiv').text('이름 입력');
	else if($('#imageContent').val() == '')
		$('#imageContentDiv').text('내용 입력');
	else
		$.ajax({
			type: 'post',
			url: '/mini/user/updateUpload',
			data: $('#updateUploadForm').serialize(), //변수=값&변수=값
			success: function(){
				alert('이미지 수정 완료');
				location.href = '/mini/user/uploadList';
			},
			error: function(e){
				console.log(e);
			}
		});
});
