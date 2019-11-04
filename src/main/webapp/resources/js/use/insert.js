/**
 * COMMON
 */

$().ready(function() {
	$('#content').summernote({
		height : 300,
		lang : 'ko-KR',
		minHeight : null, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true
	});

	$('.note-icon-trash').trigger('click');

})
