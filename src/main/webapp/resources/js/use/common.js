/**
 * COMMON
 */

$().ready(function() {
	$('.common-sns').click(function(){
		alert('준비중 입니다.');
	})
	$('#logOut').click(function() {
		$.ajax({
	        method: "POST",
	        url: pageUrl + "members/api/logout",
	        success: function() {
	        	location.reload();
	        }
	    });
	})
})
