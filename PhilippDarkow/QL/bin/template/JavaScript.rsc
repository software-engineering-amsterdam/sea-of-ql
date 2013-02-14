module template::JavaScript

import syntax::AbstractSyntax;
import template::StringTemplate;
import template::File;

public str javaScriptCreateForm(str id, list[Body] Body){
	str f = "function createForm(){
			<id> = document.createElement(\"form\");
			<id>.setAttribute(\'method\',\"post\");
			<id>.setAttribute(\'action\',\"submit.php\");
			<id>.setAttribute(\'name\',<id>);
			<id>.setAttribute(\'id\',<id>);
			<for (s <- Body) { >						
			<generateBody(id,s)>					
			< } >
			<createSubmitButton(id)>
			<id>.appendChild(<id>Submit);
			document.getElementsByTagName(\'body\')[0].appendChild(<id>);		
		} ";
		appendToJavaScriptFile(id, f);
		return f;
}

str createSubmitButton(str id){
	str d = "<id>Submit = document.createElement(\'input\');
	<id>Submit.setAttribute(\'type\',\"submit\");	
		<id>Submit.setAttribute(\'name\',\"<id>Submit\");		
		<id>Submit.setAttribute(\'value\',\"Click!\");	";
	return d;
}

