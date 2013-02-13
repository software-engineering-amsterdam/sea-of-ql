module template::JavaScript

import syntax::AbstractSyntax;
import template::StringTemplate;
import template::File;

public str javaScriptCreateForm(str id, list[Body] Body){
	str f = "function createForm(){
			var <id> = document.createElement(\"form\");
			<id>.setAttribute(\'method\',\"post\");
			<id>.setAttribute(\'action\',\"submit.php\");
			<id>.setAttribute(\'name\',<id>);
			<id>.setAttribute(\'id\',<id>);
			<for (s <- Body) { >						
			<generateBody(id,s)>					
			< } >
			document.getElementsByTagName(\'body\')[0].appendChild(<id>);		
		} ";
		appendToJavaScriptFile(id, f);
		return f;
}

