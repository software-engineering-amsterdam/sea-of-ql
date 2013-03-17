module template::JavaScriptHelper

import syntax::AbstractSyntax;

public str getAddCheckStatementString(str formId, str checkBoxId, list[str] children, str ifTruePart){
	return "function <checkBoxId>DoTheCheckWithStatement(cb) {
					'	if(cb.checked) {
					'	<formId>.removeChild(<formId>Submit);
					'	<ifTruePart>
					'	<formId>.appendChild(<formId>Submit);
					'	}else {
					'	<for(c <- children){> <formId>.removeChild(<c>Paragraph); <}>
					'	}
					'}";
}

public str getSubmitMethodString(str formId){
	return "function submit<formId>() {
				'	alert(\'submit button pressed\'); 
				'} ";
}

public str getOnChangeForComputedString(str formId, str id, str methodName){
	return "function <id>CheckNumeric(cb) {
				'	<methodName>Calculation(<methodName>);
				'	if(isNaN(cb.value)) { 
				'		alert(\"Trying to hack the questionaire please reload \");
				'		<formId>Submit.setAttribute(\'hidden\', true);
				'	}
				'}";
}

public str getAddCheckBooleanString(str checkBoxId){
	return "function <checkBoxId> {
					'	if(cb.checked == true) { cb.parentNode.children[2].innerHTML = \"No\"; }
	    			'	if(cb.checked == false) { cb.parentNode.children[2].innerHTML = \"Yes\"; }
	    			'}"; 
}

public str getAddCheckNumberString(str checkBoxId){
	return "function <checkBoxId> {
						'	if(isNaN(cb.value)) { alert(\"is not number\"); } 
						'}";
}

public str getCreateFormString(str id, list[Body] Body){
	return "function createForm(){ 
	        '	<id>Div = document.createElement(\"div\");
	        '	<id>Div.setAttribute(\'name\',\'<id>Div\'); 
	        '	<id>Div.setAttribute(\'id\',<id>Div);
	 		'	<id>Div.setAttribute(\'class\',\'<id>Div\');
	 		'	<id> = document.createElement(\"form\"); 
	 		'	<id>.setAttribute(\'method\',\"post\");
	 		'	<id>.setAttribute(\'action\',\"<id>.php\"); 
	 		'	<id>.setAttribute(\'name\',\'<id>\'); 
	 		'	<id>.setAttribute(\'id\',<id>);
	 		'	<for (s <- Body) { > <generateBody(id,s, Body)> < } > <createSubmitButton(id)>
	 		'	<id>.appendChild(<id>Submit);
	 		'	<id>Div.appendChild(<id>);
	 		'	document.getElementsByTagName(\'body\')[0].appendChild(<id>Div);
	 '} ";
}