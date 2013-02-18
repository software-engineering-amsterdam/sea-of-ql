function processUserResponse(url, inputObj) {
	var jqueryInput = $(inputObj);
	var value = jqueryInput.is(':checked'); 
	var ident = jqueryInput.parent().find('input:hidden').val();
	$.ajax({
		type: "POST",
		url: url,
		data: { answer: value, identName: ident }
	}).done(function( msg ) {
		$('#extraQuestions').html(msg);
	});

}
