$(function(){
	$.ajax({
		type: 'post',
		url: '/user/getUserList',
		dataType: 'json', //text, html, xml, json
		success: function(data){
			//alert(JSON.stringify(data));
			
			$.each(data, function(index, items){
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.pwd
				})).appendTo($('#userListTable'));    
			});
			
		},
		error: function(err){
			console.log(err);
		}
	});
});

// 검색
$('#searchBtn').click(function(){
	if($('#keyword').val() == '')
		alert('검색어를 입력하세요')
	else
		$.ajax({
			type : 'post',
			url :'/user/search',
/*
			data : {'searchOption':$('#searchOption').val(),
			'keyword':$('#keyword').val()}
*/			
			 data : $('#searchForm').serialize(),  // serialize를 쓰면 둘중 하나 쓰기 id속성만으로는 넘어가지 않음 name 속성이 필요
			 dataType: 'json',
			 success:function(data){
				 console.log(JSON.stringify(data));
				 $('#userListTable tr:gt(0)').remove(); //tr의 값이 0 ㅂ다 큰경우 즉 값이 있음 그 값을 지워라
				 
				$.each(data,function(index, items){
			
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.pwd
				})).appendTo($('#userListTable'));    
				});
				 
			 },
			 error : function(err){
				 console.log(err);
			 }
		});
});














