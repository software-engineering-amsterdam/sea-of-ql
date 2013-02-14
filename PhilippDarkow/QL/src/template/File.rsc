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
	loc l = |home:///TestQLJavaScript|;
	l += "<formId>.css";
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

public void javaScriptAddCheckFunction(str formId, str checkBoxId) {
	str check = "function <checkBoxId>DoTheCheck(cb) {
		if(cb.checked == true)
	{ cb.parentNode.children[2].innerHTML = \"No\"; }
	if(cb.checked == false)
	{ cb.parentNode.children[2].innerHTML = \"Yes\"; }
	}"; 
	appendToJavaScriptFile(formId, "\n <check>");
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
