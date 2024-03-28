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
						src: '../storage/' + items.image1,
						style: 'width: 70px; height: 70px;'
					}))
					
				).append($('<td/>', {
					align: 'center',
					text: items.imageName
					
				})).appendTo($('#uploadListTable'));
				*/
				
				var result = `<tr>`
						   + `<td align="center">` + items.seq + `</td>`
						   + `<td align="center"><img src="../storage/` + items.image1 + `" style="width: 70px; height: 70px;"/></td>`
						   + `<td align="center">` + items.imageName + `</td>`
						   + `</tr>`;
						   
				$('#uploadListTable').append(result);
				
			});//$.each
		},
		error: function(e){
			console.log(e);
		}
	});//$.ajax
});









