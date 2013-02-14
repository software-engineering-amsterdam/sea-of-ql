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
		println("NO CREATE");
		return l;
	}else{
		println("create L : <l>");
		mkDirectory(l);
		return l;
	}
}

void generateCSSFile(str id, str css, loc l){
	l += "<id>.css";
	if(isFile(l)){
		println("append to file : <l>");
		appendToFile(l, "\n <css>");
	}else{
		writeFile(l,css);
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
	writeFile(dir,"var <id>;");
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

public void javaScriptAddCheckStatementFunction(str formId, str checkBoxId, list[str] thenPart ){
	println("THENPART!!!! : <thenPart>");
	//println("BODYYY : <body>");
	str s = "";
	for(i <- thenPart){
		println("in Loop <i>");
		s += i;
	}
	println("SS!$%& : <s>");
	list[str] u = split(".", s);
	println("UUUU : <u>");
	str check = "function <checkBoxId>DoTheCheckWithStatement(cb) {
		if(cb.checked)
	{
		<s>
	}else {
		<formId>.removeChild(<u[0]>Paragraph);
	}
	}";
	appendToJavaScriptFile(formId, "\n <check>");
}

str removeChildFromFrom(str formId, str id){
	
}

public void javaScriptAddGlobalVariable(str formId, str globalID){
	println("in add global");
	appendToJavaScriptFile(formId, globalID);
}