/**
 * BOARD LIST
 */

function boardDetailAction(boardNo) {
	location.href = "/board/view/" + boardNo;
}

function boardDeleteAction(boardNo) {
	var delCon = confirm("등록하신 게시글을 지우시겠습니까?");

	if (delCon) {
		$.ajax({
	        method: "DELETE",
	        url: pageUrl + "board/api/delete/" + boardNo,
	        success: function() {
	        	alert('게시글이 지워졌습니다.');
	        	location.reload();
	        }
	    });		
	}
}
