/**
 * MEMBER INSERT
 */

var pageUrl = window.location.href;
$().ready(function() {
	$('#insertBtn').click(function() {
		$.ajax({
	        method: "POST",
	        url: pageUrl + "members/api/add",
	        data: JSON.stringify({
	            email: $('#email').val(),
	            pwd: $('#pwd').val(),
	            name: $('#name').val(),
	            phone: $('#phone').val(),
	            address : '임시_주소'
	        }),
	        contentType: "application/json; charset=utf-8",
	        success: function() {
	        	alert($('#name').val() + '님 환영합니다.\n');
	        	location.reload();
	        }
	    });
	});
});