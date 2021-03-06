/**
 * MEMBER REGISTER
 */

$().ready(function() {
	$('#registerBtn').click(function() {
		$.ajax({
	        method: "POST",
	        url: pageUrl + "members/api/register",
	        data: JSON.stringify({
	            email: $('#email').val(),
	            pwd: $('#pwd').val(),
	            name: $('#name').val(),
	            phone: $('#phone').val(),
	            address : $('#address').val()
	        }),
	        contentType: "application/json; charset=utf-8",
	        success: function() {
	        	alert($('#name').val() + '님 회원가입을 환영합니다.\n');
	        	location.href = "/";
	        }
	    });
	});
});