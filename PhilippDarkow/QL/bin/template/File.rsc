module template::File

import IO;
import Prelude;
import syntax::AbstractSyntax;
import template::StringTemplate;
import template::CSS;
import template::JavaScript;
import template::EvaluateExpression;

/** Method to create a QL directory and files
* @param id the name of the questionaire will be used as filename
* @author Philipp
*/
public void createQLOnHarddisk(str id){
	loc dir = generateQLDirectory(id);		// generate a directoy and get the location of the directory
	createEmptyHTMLFile(id, dir);			// create an empty HTML File
	createEmptyJavaScriptFile(id, dir);		// create an empty JavaScript File
	createEmptyCSSFile(id, dir);			// create an empty CSS File
	createEmptyPHPFile(id, dir);			// create an empty PHP File
}

/** Method to generate a directory for the JavaScript Program
* @return l the location of the directory
* @ author Philipp
*/
loc generateQLDirectory(str id){
	l = |file:///wamp/www/<id>|;		// get location for directory
	if(isDirectory(l)) return l;		// check if directory exits
	else{
		mkDirectory(l);
		return l;
	}
}

/** Method to append code to an HTML File
* @param formId the questionaire name
* @param test the code to append
* @author Philipp
*/
public void appendToHTMLFile(str formId, str text){
	l = |file:///wamp/www/<formId>|;
	l += "<formId>.html";
	appendToFile(l, "\n <text>");
}

/** Method to create an emtpy HTML file on the file system the questionaire name is used as filename
* @param id the name of the questionaire
* @param dir the location of the directory
* @author Philipp
*/
void createEmptyHTMLFile(str formId, loc dir){
	dir += "<formId>.html";
	writeFile(dir,"");
}

/** Method to create an emtpy JavaScript file on the file system the questionaire name is used as filename
* @param id the name of the questionaire
* @param dir the location of the directory
* @author Philipp
*/
void createEmptyJavaScriptFile(str id, loc dir){
	dir += "<id>.js";
	writeFile(dir,"var <id>;
	var <id>Submit;");
}

/** Method to create an emtpy CSS File on the file system the questionaire name is used as filename
* @param id the name of the questionaire
* @param dir the location of the directory
* @author Philipp
*/
void createEmptyCSSFile(str id, loc dir){
	dir += "<id>.css";
	writeFile(dir,"");
}

/** Method to create an emtpy PHP File on the file system the questionaire name is used as filename
* @param id the name of the questionaire
* @param dir the location of the directory
* @author Philipp
*/
void createEmptyPHPFile(str id, loc dir){
	dir += "<id>.php";
	writeFile(dir,"\<?php ");
}

public void javaScriptAddCheckStatementFunction(str formId, str checkBoxId, list[str] thenPart, str exp,list[str] children){
	str ifTrue = "";
	for(i <- thenPart) ifTrue += i;
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
