module template::File

import IO;
import Prelude;
import syntax::AbstractSyntax;
import template::StringTemplate;
import template::CSS;
import template::JavaScript;

/** Method to generate a directory for the JavaScript Program
* @return l the location of the directory
* @ author Philipp
*/
loc generateQLDirectory(){
	l = |home:///TestQLJavaScript|;
	if(isDirectory(l)){
		return l;
	}else{
		mkDirectory(l);
		return l;
	}
}

public void appendToHTMLFile(str formId, str text){
	loc l = |home:///TestQLJavaScript|;
	l += "<formId>.html";
	appendToFile(l, "\n <text>");
}

public void appendToJavaScriptFile(str formId, str text){
	loc l = |home:///TestQLJavaScript|;
	l += "<formId>.js";	
	appendToFile(l, "\n <text>");
}

public void appendToCssFile(str formId, str text){
	println("in append to : <text>");
	loc l = |home:///TestQLJavaScript|;
	l += "<formId>.css";
	println("L : <l>");
	appendToFile(l, "\n <text>");
}

public void createQLOnHarddisk(str id){
	loc dir = generateQLDirectory();
	createEmptyHTMLFile(id, dir);
	createEmptyJavaScriptFile(id, dir);
	createEmptyCSSFile(id, dir);
	createValidatorFile(dir);
}

void createEmptyHTMLFile(str id, loc dir){
	dir += "<id>.html";
	writeFile(dir,"");
}

void createEmptyJavaScriptFile(str id, loc dir){
	dir += "<id>.js";
	writeFile(dir,"var <id>;
	var <id>Submit;");
}

void createEmptyCSSFile(str id, loc dir){
	dir += "<id>.css";
	writeFile(dir,"");
}

public void generateCSSFile(str formId, str id){
	loc dir = generateQLDirectory();
	s = cssEndLabels(id);
	generateCSSFile(formId,s,dir);
}

void createValidatorFile(loc l){
	l += "gen_validatorv4.js";
	str v = readFile(|project://QL/src/template/Validator|);
	writeFile(l, v);
}

public void javaScriptAddCheckFunction(str formId, str checkBoxId, Type tp) {
	str function = "";
	if(tp == boolean()){
	function = "function <checkBoxId> {
		if(cb.checked == true)
	{ cb.parentNode.children[2].innerHTML = \"No\"; }
	if(cb.checked == false)
	{ cb.parentNode.children[2].innerHTML = \"Yes\"; }
	}"; 
	}else{
	function = "function <checkBoxId> {
	{ console.log(cb); }
	if(isNaN(cb.value))
	{ alert(\"is not number\"); }
	}"; 
	}
	appendToJavaScriptFile(formId, "\n <function>");
}

public void javaScriptAddCheckStatementFunction(str formId, str checkBoxId, list[str] thenPart, list[str] children){
	str ifTrue = "";
	for(i <- thenPart){
		ifTrue += i;
	}
	str check = "function <checkBoxId>DoTheCheckWithStatement(cb) {
	if(cb.checked)
	{
		<formId>.removeChild(<formId>Submit);
		<ifTrue>
		<formId>.appendChild(<formId>Submit);
	}else {
		<for(c <- children){>
		<formId>.removeChild(<c>Paragraph);
		<}>
	}
	}";
	appendToJavaScriptFile(formId, "\n <check>");
}

public void javaScriptAddGlobalVariable(str formId, str globalID) =
	appendToJavaScriptFile(formId, globalID);

public void javaScriptAddEvaluateQuestion(str formId, Expression exp){
	println("in evaluate question");  // i need to create a onchange function which checks the values of the exps
}