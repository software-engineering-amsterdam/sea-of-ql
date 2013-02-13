module template::StringTemplate

import IO;
import String;
import Prelude;
import syntax::AbstractSyntax;
import typeChecker::TypeCheck;
import util::Load;
import template::File;
import template::JavaScript;

// Capitalize the first character of a string

public str capitalize(str s) {  
  return toUpperCase(substring(s, 0, 1)) + substring(s, 1);
}

/** Method to generate the JavaScript code for a question label
* @param id the id of the question used for naming
* @param label the label text
* @return str a string with java script code
* @author Philipp
*/
private str generateQuestionLabel(str id, str label){
	return "var <id>Label = document.createElement(\'label\');
	 <id>Label.htmlFor = <id>;
	 <id>Label.innerHTML = <label>; ";
}

/** Method to generate the JavaScript code for the end part of a question
* @param id the id of the question used for naming
* @return str a string with java script code
* @author Philipp
*/
private str createEndingLabel(str id){
	return "var <id>EndLabel = document.createElement(\'label\');
	 <id>EndLabel.htmlFor = <id>;
	 <id>EndLabel.innerHTML = \"Yes\"; 
	 <id>EndLabel.class = \"<id>EndClass\" ";
}

/** Method to set the attributes of a checkBox in java script
* @param id the id of te question is used as id, name and value of the checkbox
* @return str a java code snipped as string
*/
private str specifyAttributesCheckbox(str id){
	return "<id>.setAttribute(\'type\',\"checkbox\");
		<id>.setAttribute(\'id\',<id>);
		<id>.setAttribute(\'name\',<id>);
		<id>.setAttribute(\'value\',<id>); ";
}

str specifyAttributesNumeric(str id){
	return "<id>.setAttribute(\'type\',\"text\");
		<id>.setAttribute(\'id\',<id>);
		<id>.setAttribute(\'name\',<id>);
		 ";
}

str generateParagraph(str id, str att, str lab, str endlab){
	str p = "var <id>Paragraph = document.createElement(\'p\');
	<id>Paragraph.setAttribute(\"class\", <id>Paragraph);
	<id>Paragraph.appendChild(<id>Label);
	<id>Paragraph.appendChild(<id>);
	<id>Paragraph.appendChild(<id>EndLabel);
	";
	
	return p;
}

str generateParagraph(str id, str label, str attributes){
	str p = "var <id>Paragraph = document.createElement(\'p\');
	<id>Paragraph.setAttribute(\"class\", <id>Paragraph);
	<id>Paragraph.appendChild(<id>Label);
	<id>Paragraph.appendChild(<id>);
	";
	
	return p;
}

/** Method to generate Question 
*/
private str generateQuestion(str formId, question:easyQuestion(str id, str labelQuestion, Type tp)){
	println("in generate Question <question>");
	// document.write(\"\<p\>  \</p\>\");
	str label = generateQuestionLabel(id, labelQuestion);
	if(tp == boolean()){	
		str attributes = specifyAttributesCheckbox(id);
		str check = createEndingLabel(id);
		str paragraph = generateParagraph(id, label, attributes, check);
		generateCSSFile(formId, id);
		return "var <id> = document.createElement(\"input\");
		<attributes> 
		<label>
		<check>
		<paragraph>
		<formId>.appendChild(<id>Paragraph);	
		 ";
	}else if(tp == money()){
		println("in money generate Easy Question");
		str attributes = specifyAttributesNumeric(id);
		str paragraph = generateParagraph(id, label, attributes);
		return "var <id> = document.createElement(\"input\");
		<attributes>
		<label>
		<paragraph>
		<formId>.appendChild(<id>Paragraph);
		 ";
		//return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}else if(tp == string()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}
	
}

private str generateQuestion(str formId, question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	println("in generate computed Question <question>");
	if(tp == boolean()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}
	
}

//private str generateBody(list[Body] body){
//	list[str] ques = [];
//	for(s <- body){
//		visit(s){
//			case Question q : {
//				ques += generateQuestion(q);
//			}
//		}
//	}
//	return ques;	
//}

public str generateBody(str id, Body body){
	println("in generate Body <body>");
	for(s <- body){
		visit(s){
			case Question q : {
				return generateQuestion(id, q);
			}
			case Statement s : {
				return generateStatement(s);
			}
		}
	}	
}

public str generateQLForm(Program P){
	if(program(str id, list[Body] Body) := P){
		println("in generate JavaScriptForm");
		str res = "\<!DOCTYPE html\>
		\<html\>
		\<head\>
		\<script src=\"<id>.js\"\>
		\</script\>
		\<link href=\"<id>.css\" rel=\"stylesheet\" type=\"text/css\"\>
		\</head\>
		\<body\>
		\<script\>
			createForm();
		\</script\>
		\</body\>
		\</html\>";	
		str functions = javaScriptCreateForm(id, Body);
		generateQLProgram(id,res,functions);
		return res;
	}else{
		return "not possible to generate java script code";
	}
}

public str generateQLForm(str txt) = generateQLForm(load(txt));


//function yesno(thecheckbox, thelabel) {
    	//var checkboxvar = document.getElementById(thecheckbox);
    	//var labelvar = document.getElementById(thelabel);
    	//	if (!checkboxvar.checked) {
        //		labelvar.innerHTML = \"Noddddddddddd\";
    	//	}
    	//	else {
        //		labelvar.innerHTML = \"Yesaaaaaaaaaa\";
    	//	}
		//}