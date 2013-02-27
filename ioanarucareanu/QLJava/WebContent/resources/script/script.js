function processUserResponse(url, inputObj) {
	var jqueryInput = $(inputObj);
	var value;
	if (jqueryInput.is(':checkbox')) {
		value = jqueryInput.is(':checked');
	} 
	if (jqueryInput.is(':text')) {
		value = jqueryInput.val();
	} 
	var ident = jqueryInput.parent().find('.identHolder').attr("name");
	$.ajax({
		type: "POST",
		url: url,
		data: { answer: value, identName: ident }
	}).done(function(msg) {
//		var form = $("form");
//        form.append(msg);
		$("#content").html(msg);
	});
}
