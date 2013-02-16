module template::JavaScript

import syntax::AbstractSyntax;
import template::StringTemplate;
import template::File;
import template::CSS;
import Prelude;

public str javaScriptCreateForm(str id, list[Body] Body){
	str f = "function createForm(){
			<id>Div = document.createElement(\"div\");
			<id>Div.setAttribute(\'name\',<id>Div);
			<id>Div.setAttribute(\'id\',<id>Div);
			<id>Div.setAttribute(\'class\',\'<id>Div\');
			<id> = document.createElement(\"form\");
			<id>.setAttribute(\'method\',\"post\");
			<id>.setAttribute(\'action\',\"<id>.php\");
			<id>.setAttribute(\'name\',<id>);
			<id>.setAttribute(\'id\',<id>);
			<for (s <- Body) { >						
			<generateBody(id,s)>					
			< } >
			<createSubmitButton(id)>
			<id>.appendChild(<id>Submit);
			<id>Div.appendChild(<id>);
			
			document.getElementsByTagName(\'body\')[0].appendChild(<id>Div);		
		} ";
		appendToJavaScriptFile(id, f);
		createSubmitMethod(id);
		return f;
}

str createSubmitButton(str id){
	str d = "<id>Submit = document.createElement(\'input\');
	<id>Submit.setAttribute(\'type\',\"submit\");	
		<id>Submit.setAttribute(\'name\',\"<id>Submit\");		
		<id>Submit.setAttribute(\'value\',\"Submit\");
		<id>Submit.setAttribute(\'onclick\',\"submit<id>()\");	";
	return d;
}

void createSubmitMethod(str id){
	str result = "function submit<id>()
	{ alert(\'submit button pressed\'); } ";
	appendToJavaScriptFile(id, result);
}