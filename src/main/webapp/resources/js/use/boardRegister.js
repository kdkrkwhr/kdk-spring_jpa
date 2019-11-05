/**
 * BOARD REGISTER
 */

$().ready(function() {
	$('#content').summernote({
		height : 300,
		lang : 'ko-KR',
		minHeight : null, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true,
		popover : { //팝오버 설정
			image : [], //이미지 삭제
			link : [], //링크 삭제
			air : []
		}
	});

	$('.note-icon-trash').trigger('click');
	
	$('#registerBtn').click(function() {
		$.ajax({
			method : "POST",
			url : "board/api/register",
			data : JSON.stringify({
				subject : $('#subject').val(),
				content : $('#content').val(),
				boardCat : $('#boardCat').val(),
				memberNo : $('#memberNo').val(),
				totalPersonCnt : $('select[name=totalPersonCnt]').val(),
				communication : $('#communication').val()
			}),
			contentType : "application/json; charset=utf-8",
			success : function() {
				alert("게시물이 등록 되었습니다.");
				location.href = "/board/" + $('#boardCat').val();
			}
		});
	});
})
