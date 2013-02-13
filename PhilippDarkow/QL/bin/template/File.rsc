module template::File

import IO;
import syntax::AbstractSyntax;
import template::StringTemplate;

/** Method to generate a directory for the JavaScript Program
* @return l the location of the directory
* @ author Philipp
*/
loc generateQLDirectory(){
	l = |home:///TestQLJavaScript|;
	if(isDirectory(l)){
		println("NO CREATE");
		return l;
	}else{
		println("create L : <l>");
		mkDirectory(l);
		return l;
	}
}

/** Method 
*/
void generateHTMLFile(str id, str program, loc l){
	l += "<id>.html";
	println("LOC : <l>");
	writeFile(l,program);
}

void generateJavaScriptFile(str id, str func, loc l){
	l += "<id>.js";
	println("create empty js file");
	writeFile(l, func);
}

public void generateQLProgram(str id, str program, str func){
	loc dir = generateQLDirectory();
	generateHTMLFile(id,program,dir);
	generateJavaScriptFile(id,func,dir);
}

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