$(function(){
	$.ajax({
		type: 'post',
		url: '/mini/user/getUploadList',
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$.each(data, function(index, items){
			
				/*
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.seq
					
				})).append($('<td/>', {
					align: 'center',
					}).append($('<img/>', {
						src: '../storage/' + items.imageOriginalName,
						style: 'width: 70px; height: 70px;'
					}))
					
				).append($('<td/>', {
					align: 'center',
					text: items.imageName
					
				})).appendTo($('#uploadListTable'));
				*/
				/*
				var result = `<tr>`
						   + `<td align="center">` + items.seq + `</td>`
						   + `<td align="center"><img src="../storage/` + items.imageOriginalName + `" style="width: 70px; height: 70px;"/></td>`
						   + `<td align="center">` + items.imageName + `</td>`
						   + `</tr>`;
						   
				$('#uploadListTable').append(result);
				*/
				
				//이미지는 MySQL Local DB 말고 NCloud MySQL DB에서 꺼내오기
				var result = `<tr>`
						   + `<td align="center">` 
						   		+`<input type="checkbox" name="check" id="check" value="`+items.seq+`" >`+ items.seq 
						   +`</td>`
						   + `<td align="center">`
						   		+`<a href="/mini/user/uploadView?seq=`+items.seq+`">`
						   			//imageOriginalName->imageFilelName
							   		+`<img src="https://kr.object.ncloudstorage.com/bitcamp-6th-bucket-105/storage/`+items.imageOriginalName+`"style="width: 70px; height: 70px;"/>`
								+`</a>`
						   +`</td>`
						   + `<td align="center">` + items.imageName + `</td>`
						   
						   + `</tr>`;
		
				$('#uploadListTable').append(result);
			});  //$.each
			
			//checkbox 전체 선택 및 해제
			$('#all').click(function() {
    			if($(this).prop('checked')){
        			$('input[name="check"]').prop('checked',true);
    			}else{
        		$('input[name="check"]').prop('checked',false);
    			}
			});  //all.click
			
			//전체 선택 후 일부 해제 시 전체 선택 해제되도록
			$('input[name="check"]').click(function(){
				//체크된거개수==체크박스개수
				$('#all').prop('checked', $('input[name="check"]:checked').length == $('input[name="check"]').length);
			});
			
		},
		error: function(e){
			console.log(e);
		}
	});//$.ajax
	
	$('#uploadDeleteBtn').click(function(){
		$.ajax({
			type:'post'
			,url:'/mini/user/uploadDelete'
			,data: $('#uploadListForm').seralize()
			,dataType:'text'
			,success:function(data){
				alert("이미지 삭제 완료");
				location.href='/mini/user/uploadList.jsp';
			},error: function(e){
			console.log(e);
			}
		})//ajax
	
	});//uploadDeleteBtn.click	
});









