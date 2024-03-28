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
            
            $('#imageSpan').html(result);
            $('#imageNameSpan').html(data.imageName);
            $('#imageOriginalNameSpan').html(data.imageOriginalName);
            $('#imageContentSpan').html(data.imageContent);
        },
		error: function(e){
			console.log(e);
		}
    });//ajax

});
