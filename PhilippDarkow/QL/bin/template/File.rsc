module template::File

import IO;
import Prelude;
import syntax::AbstractSyntax;
import template::StringTemplate;
import template::CSS;
import template::JavaScript;
import template::EvaluateExpression;

/** Method to create a QL directory and files
* @param
* @authot Philipp
*/
public void createQLOnHarddisk(str id){
	loc dir = generateQLDirectory(id);
	createEmptyHTMLFile(id, dir);
	createEmptyJavaScriptFile(id, dir);
	createEmptyCSSFile(id, dir);
	createEmptyPHPFile(id, dir);
}

/** Method to generate a directory for the JavaScript Program
* @return l the location of the directory
* @ author Philipp
*/
loc generateQLDirectory(str id){
	l = |file:///wamp/www/|;
	l += id;
	if(isDirectory(l)) return l;
	else{
		mkDirectory(l);
		return l;
	}
}

public void appendToHTMLFile(str formId, str text){
	l = |file:///wamp/www/<formId>|;
	l += "<formId>.html";
	appendToFile(l, "\n <text>");
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

void createEmptyPHPFile(str id, loc dir){
	dir += "<id>.php";
	writeFile(dir,"\<?php ");
}

public void generateCSSFile(str formId, str id){
	loc dir = generateQLDirectory(formId);
	s = cssEndLabels(id);
	generateCSSFile(formId,s,dir);
}

public void javaScriptAddCheckStatementFunction(str formId, str checkBoxId, list[str] thenPart, str exp,list[str] children){
	str ifTrue = "";
	for(i <- thenPart){
		ifTrue += i;
	}
	str check = "function <checkBoxId> {
	' if(<exp>)
	' {
		' <formId>.removeChild(<formId>Submit);
		' <ifTrue>
		' <formId>.appendChild(<formId>Submit);
	' }else {
		' if(<children[0]>Paragraph.parentNode != null)
		' {
		' <for(c <- children){>
		' <formId>.removeChild(<c>Paragraph);
		' <}>
		' }
	' }
	'}";
	appendToJavaScriptFile(formId, "\n <check>");
}
