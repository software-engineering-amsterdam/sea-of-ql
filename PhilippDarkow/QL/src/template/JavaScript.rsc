module template::JavaScript

import syntax::AbstractSyntax;
import template::StringTemplate;
import template::File;
import template::CSS;
import template::EvaluateExpression;
import Prelude;

/** Method to create the javascript code to generate the form
* @param id the name of the questionaire
* @param Body the Body of the questionaire
* @author Philipp
*/
public void javaScriptCreateForm(str id, list[Body] Body){
	str f = "function createForm(){ 
	        '	<id>Div = document.createElement(\"div\");
	        '	<id>Div.setAttribute(\'name\',\'<id>Div\'); 
	        '	<id>Div.setAttribute(\'id\',<id>Div);
	 		'	<id>Div.setAttribute(\'class\',\'<id>Div\');
	 		'	<id> = document.createElement(\"form\"); 
	 		'	<id>.setAttribute(\'method\',\"post\");
	 		'	<id>.setAttribute(\'action\',\"<id>.php\"); 
	 		'	<id>.setAttribute(\'name\',\'<id>\'); 
	 		'	<id>.setAttribute(\'id\',<id>);
	 		'	<for (s <- Body) { > <generateBody(id,s, Body)> < } > <createSubmitButton(id)>
	 		'	<id>.appendChild(<id>Submit);
	 		'	<id>Div.appendChild(<id>);
	 		'	document.getElementsByTagName(\'body\')[0].appendChild(<id>Div);
	 '} ";
	appendToJavaScriptFile(id, f);
	createSubmitMethod(id);
}

/** Method to create the Submit button of the form in javascript
* @param id the name of the questionaire
* @return str with the code snipped for a submit button
* @author Philipp
*/
str createSubmitButton(str id) = "	<id>Submit = document.createElement(\'input\');
								'	<id>Submit.setAttribute(\'type\',\"submit\"); 
								'	<id>Submit.setAttribute(\'name\',\"<id>Submit\");		
								'	<id>Submit.setAttribute(\'value\',\"Submit\");
								'	<id>Submit.setAttribute(\'onclick\',\"submit<id>()\");";


/** Method to create a submit action when the submit button is pressed
* @param id the name of the questionaire
* @author Philipp
*/
void createSubmitMethod(str id){
	str result = "function submit<id>() {
				'	alert(\'submit button pressed\'); 
				'} ";
	appendToJavaScriptFile(id, result);
}

/** Method to create the code for the 
* @param formId the name of the questionaire
* @param checkBoxId the name of the question
* @param tp the type of the question
* @author Philipp
*/
public void javaScriptAddCheckFunction(str formId, str checkBoxId, Type tp) {
	str function = "";
	if(tp == boolean()){
		function = "function <checkBoxId> {
					'	if(cb.checked == true) { cb.parentNode.children[2].innerHTML = \"No\"; }
	    			'	if(cb.checked == false) { cb.parentNode.children[2].innerHTML = \"Yes\"; }
	    			'}"; 
	}else{
		function = "function <checkBoxId> {
						'	if(isNaN(cb.value)) { alert(\"is not number\"); } 
						'}"; 
	}
	appendToJavaScriptFile(formId, "\n <function>");
}

/** Method to create an if statement function if the condition is a boolean in JavaScript
* @param formId the name of the questionaire
* @param checkboxId the name of the  
* @param thenPart the then part of the the if statement
* @param children the ids of the questions in the then part
* @author Philipp
*/
public void javaScriptAddCheckStatementFunction(str formId, str checkBoxId, list[str] thenPart, list[str] children){
	str ifTruePart = "";
	for(i <- thenPart) ifTruePart += i;
	str check = "function <checkBoxId>DoTheCheckWithStatement(cb) {
					'	if(cb.checked) {
					'	<formId>.removeChild(<formId>Submit);
					'	<ifTruePart>
					'	<formId>.appendChild(<formId>Submit);
					'	}else {
					'	<for(c <- children){> <formId>.removeChild(<c>Paragraph); <}>
					'	}
					'}";
	appendToJavaScriptFile(formId, "\n <check>");
}

public str javaScriptaddIfElseStatementBoolean(str formId, str varId, list[str] thenPart, list[str] elsePart, list[str] children, list[str] childrenElse){
	println("IN JAVASCRIPT IF ELSE Boolean");
	str ifTruePart = "";
	str elsePartString = "";
	for(i <- thenPart) ifTruePart += i;
	for(j <- elsePart) elsePartString += j;
	str check = "function <varId>IfElseStatementBoolean(cb) {
					'	if(cb.checked) {
					'	<formId>.removeChild(<formId>Submit);
					'	<for(i <- childrenElse){> <formId>.removeChild(<i>Paragraph); <}>
					'	<ifTruePart>
					'	<formId>.appendChild(<formId>Submit);
					'	}else {
					'	<formId>.removeChild(<formId>Submit);
					'	<for(c <- children){> <formId>.removeChild(<c>Paragraph); <}>
					'	<for(i <- childrenElse){> <formId>.appendChild(<i>Paragraph); <}>
					'	<formId>.appendChild(<formId>Submit);
					'	}
					'}";
	appendToJavaScriptFile(formId, "\n <check>");
	return elsePartString;
}

public str javaScriptaddIfElseStatement(str formId, list[str] varId, list[str] thenPart, list[str] elsePart, list[str] children, list[str] childrenElse, str check){
	println("IN JAVASCRIPT IF ELSE <check>");
	str ifTruePart = "";
	str elsePartString = "";
	for(i <- thenPart) ifTruePart += i;
	for(j <- elsePart) elsePartString += j;
	for(s <- varId){
		str check = "function <s>IfElseStatement(cb) {
					'	if(<check>) {
					'	<formId>.removeChild(<formId>Submit);
					'	<ifTruePart>
					'	<formId>.appendChild(<formId>Submit);
					'	<for(i <- childrenElse){> <formId>.removeChild(<i>Paragraph); <}>
					'	}else {
					'	<formId>.removeChild(<formId>Submit);
					'	<for(c <- children){> <formId>.removeChild(<c>Paragraph); <}>
					'	<for(i <- childrenElse){> <formId>.appendChild(<i>Paragraph); <}>
					'	<formId>.appendChild(<formId>Submit);
					'	}
					'}";
	appendToJavaScriptFile(formId, "\n <check>");
	}
	return elsePartString;
}

/** Method to create a javascript function to evaluate a expression
* @param formId the name of the questionaire
* @param exp the expression to evaluate
* @author Philipp
*/
public void javaScriptAddEvaluateQuestion(str formId, str id, Expression exp, Type tp){
	list[value] expressionIds = [];
	top-down visit(exp){
		case Expression e : {
			if(getName(e) == "id") expressionIds += getChildren(e);
		}
	}
	str ev = evaluateExp(exp, tp);
	for(j <- expressionIds) addOnChangeForComputedFunction(formId, toString(j) , id);
	str result = "function <id>Calculation(cb) {
				'	cb.value = <ev>; 
				'}";	
	appendToJavaScriptFile(formId, "\n <result>");	
}

/** Method to create javascript code for a computed question 
* @param formId the name of the questionaire
* @param id the name of the question
* @param methodName the name of the question to call
* @author Philipp
*/
void addOnChangeForComputedFunction(str formId, str id, str methodName){
	str result = "function <id>CheckNumeric(cb) {
				'	<methodName>Calculation(<methodName>);
				'	if(isNaN(cb.value)) { 
				'		alert(\"Trying to hack the questionaire please reload \");
				'		<formId>Submit.setAttribute(\'hidden\', true);
				'	}
				'}";
	appendToJavaScriptFile(formId, "\n <result>");
}

/** Method to append JavaScript code to a JavaScript file
* @param formId the name of the JavaScript file
* @param text the javascript code to append
* @author Philipp
*/
public void appendToJavaScriptFile(str formId, str text){
	l = |file:///wamp/www/<formId>/<formId>.js|;	
	appendToFile(l, "\n <text>");
}