$(function(){
	
	//아이디 찾기
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		
		$.ajax({
			type: 'post',
			url: '/user/getUser',
			data: 'id=' + $('#searchId').val(),
			//dataType: 'json',
			//서버에서 받아오는 데이터 타입은 'text', 'html', 'xml', 'json' 형식을 지정할 수 있다
			//getUser에서 id를 찾으면 제대로 JSON으로 오지만 
			//           id가 없으면 JSON으로 오지를 못한다.
			//그래서 dataType를 생략해야 한다. (dataType를 생략하면 자료에 맞게 자동으로 형식이 지정된다.)
			
			success: function(data){
				//alert(JSON.stringify(data));
				
				if(data == ''){				
					$('#resultDiv').text('찾고자 하는 아이디가 없습니다');
					$('#resultDiv').css('color', 'red');
					$('#resultDiv').css('font-weight', 'red');
				}else{
					//삭제
					if(confirm('삭제하시겠습니까?')){
						$.ajax({
							type: 'post',
							url: '/user/delete',
							data: 'id=' + $('#searchId').val(),
							success: function(){
								alert("회원님의 정보를 삭제하였습니다.");
								location.href='/user/list';
							},
							error:function(err){
								console.log(err);
							}
						});
					}//if
				}//else
			},
			error: function(err){
				console.log(err);
			}
		});//$.ajax
	});
});




