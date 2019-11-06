/**
 * COMMON
 */
var pageUrl = window.location.hostname;
pageUrl = "http://" + pageUrl + ":8888/";
function boardDetailAction(boardNo) {
	alert(boardNo);
	location.href = "/board/view/" + boardNo;
}

function boardDeleteAction(boardNo) {
	console.log('dd');
	$.ajax({
        method: "DELETE",
        url: pageUrl + "board/api/delete/" + boardNo,
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
	        url: pageUrl + "members/api/logout",
	        success: function() {
	        	alert('로그아웃 되셨습니다.');
	        	location.reload();
	        }
	    });
	})
})