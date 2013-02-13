module template::JavaScript

import syntax::AbstractSyntax;
import template::StringTemplate;

public str javaScriptCreateForm(str id, list[Body] Body){
	return "function createForm(){
			var <id> = document.createElement(\"form\");
			<id>.setAttribute(\'method\',\"post\");
			<id>.setAttribute(\'action\',\"submit.php\");
			<id>.setAttribute(\'name\',<id>);
			<for (s <- Body) { >						
			<generateBody(id,s)>					
			< } >
			document.getElementsByTagName(\'body\')[0].appendChild(<id>);		
		} ";
}