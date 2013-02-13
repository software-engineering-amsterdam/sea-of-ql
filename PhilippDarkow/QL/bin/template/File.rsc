module template::File

import IO;
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
}

void createEmptyHTMLFile(str id, loc dir){
	dir += "<id>.html";
	writeFile(dir,"");
}

void createEmptyJavaScriptFile(str id, loc dir){
	dir += "<id>.js";
	writeFile(dir,"");
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
	println("VVV : <v>");
	writeFile(l, v);
}

public void javaScriptAddCheckFunction(str formId, str checkBoxId) {
	str check = "function <checkBoxId>DoTheCheck() {
	//	if(document.<formId>.<checkBoxId>.checked == true)
	{ alert(\'<checkBoxId> is checked\'); }
	//if(document.<formId>.<checkBoxId>.checked == false)
	//{ alert(\'<checkBoxId> is not checked\'); }
	}"; 
	//javaScriptAddCheckFunction(formId, checkBoxId);
	appendToJavaScriptFile(formId, "\n <check>");
	//appendToFile(dir, "\n <check>");
}

private str javaScriptAddCheckFunction(str formId, str checkBoxId) {
	return "function <checkBoxId>DoTheCheck() {
	//	if(document.<formId>.<checkBoxId>.checked == true)
	{ alert(\'<checkBoxId> is checked\'); }
	if(document.<formId>.<checkBoxId>.checked == false)
	{ alert(\'<checkBoxId> is not checked\'); }
	}";
}

