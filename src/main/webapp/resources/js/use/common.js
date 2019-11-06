/**
 * COMMON
 */
var pageUrl = window.location.hostname;

function boardDetailAction(boardNo) {
	alert(boardNo);
	location.href = "/board/view/" + boardNo;
}

function boardDeleteAction(boardNo) {
	console.log('dd');
	$.ajax({
        method: "DELETE",
        url: "http://" + pageUrl + ":8888/board/api/delete/" + boardNo,
        success: function() {
        	alert('게시글이 지워졌습니다.');
        	location.reload();
        }
    });
}

$().ready(function() {
	$('.common-sns').click(function(){
		alert('준비중 입니다.');
	})

	$('#logOut').click(function() {
		$.ajax({
	        method: "POST",
	        url: "http://" + pageUrl + ":8888/members/api/logout",
	        success: function() {
	        	alert('로그아웃 되셨습니다.');
	        	location.reload();
	        }
	    });
	})
})