$(function(){
    $.ajax({
        type:'post'
        ,url:'/mini/user/getUploadImage'
        ,dataType:'json'
        ,data:{'seq':$('#seq').val()}
        ,success: function(data){
            console.log(JSON.stringify(data));
            
			//imageOriginalName->imageFilelName
            var result=`<img src="https://kr.object.ncloudstorage.com/bitcamp-6th-bucket-105/storage/`+data.imageOriginalName+`" width="300" height"300"/>`
          
            $('#imageName').val(data.imageName);
            $('#imageContent').val(data.imageContent);
            $('#showImgList').html(result);
        },
		error: function(e){
			console.log(e);
		}
    });//ajax
    
    $('#uploadUpdateBtn').click(function(){
		var formData = new FormData($('#uploadUpdateForm')[0]);
		
		$.ajax({
			type:'post'
			,enctype:'multipart/form-data'
			,processData:false
			,contentType:false
			,url: '/mini/user/uploadUpdate'
			,data: formData
			,success: function(data){
				alert(data);
				location.href = '/mini/user/uploadList';
			},
			error: function(e){
				console.log(e);
			}			
		});//ajax
	});
});