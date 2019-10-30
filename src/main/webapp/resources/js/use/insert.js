/**
 * MEMBER INSERT
 */
$().ready(function() {
		$('#insertBtn').click(function() {
			$.ajax({
		        method: "POST",
		        url: "http://localhost:8888/members/api/add",
		        data: JSON.stringify({
		            email: $('#name').val(),
		            pwd: '1111',
		            name: $('#name').val(),
		            phone: $('#phone').val(),
		            address : $('#address').val()
		        }),
		        contentType: "application/json; charset=utf-8",
                dataType: "json",
		        postBody : true,
		        success: function() {
		        	alert('임시 가입 완료');
		        }
		    });
		});
});