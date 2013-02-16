module template::StringTemplate

import IO;
import String;
import Prelude;
import syntax::AbstractSyntax;
import typeChecker::TypeCheck;
import util::Load;
import template::File;
import template::JavaScript;
import template::CSS;
import template::EvaluateExpression;

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
private str generateQuestionLabel(str formId, str id, str label){
	javaScriptAddGlobalVariable(formId, "var <id>Label = document.createElement(\'label\');");
	return "<id>Label.htmlFor = <id>;
	 <id>Label.innerHTML = <label>; ";
}

/** Method to generate the JavaScript code for the end part of a question
* @param id the id of the question used for naming
* @return str a string with java script code
* @author Philipp
*/
private str createEndingLabel(str formId, str id){
	javaScriptAddGlobalVariable(formId, "var <id>EndLabel = document.createElement(\'label\');");
	return "<id>EndLabel.htmlFor = <id>;
	 <id>EndLabel.innerHTML = \"Yes\"; 
	 <id>EndLabel.class = \"<id>EndClass\"; ";
}

/** Method to set the attributes of a checkBox in java script
* @param id the id of te question is used as id, name and value of the checkbox
* @return str a java code snipped as string
*/
private str specifyAttributesCheckbox(str id){
	return "<id>.setAttribute(\'type\',\"checkbox\");
		<id>.setAttribute(\'id\',<id>);
		<id>.setAttribute(\'name\',\'<id>\');
		<id>.setAttribute(\'value\',<id>);
		<id>.setAttribute(\'onclick\',\"<id>DoTheCheck(this)\");
		 ";
}

str specifyAttributesNumeric(str id){
	return "<id>.setAttribute(\'type\',\"text\");
		<id>.setAttribute(\'id\',<id>);
		<id>.setAttribute(\'name\',\'<id>\');
		<id>.setAttribute(\'onchange\',\"<id>CheckNumeric(this)\");
		 ";
}

str specifyAttributesCalculation(str id){
	return "<id>.setAttribute(\'type\',\"text\");
		<id>.setAttribute(\'id\',<id>);
		<id>.setAttribute(\'name\',\'<id>\');
		<id>.setAttribute(\'readOnly\',\'readonly\');
		<id>.setAttribute(\'onchange\',\"<id>Calculation(this)\");
		 ";
}

str specifyAttributesTextField(str id){
	return "<id>.setAttribute(\'type\',\"text\");
		<id>.setAttribute(\'id\',<id>);
		<id>.setAttribute(\'name\',\'<id>\');
		 ";
}

/** Method to generate a paragraph for a boolean question has as endlabel Yes or No
* @param id the id of the boolean question
* @return p the paragraph as a string
* @author Philipp
*/
str generateParagraph(str id, str att, str lab, str endlab, str formId){
	javaScriptAddGlobalVariable(formId, "var <id>Paragraph = document.createElement(\'p\');");
	str p = "<id>Paragraph.setAttribute(\"class\", \'<id>Paragraph\');
	<id>Paragraph.setAttribute(\"id\", <id>Paragraph);
	<id>Paragraph.appendChild(<id>Label);
	<id>Paragraph.appendChild(<id>);
	<id>Paragraph.appendChild(<id>EndLabel);
	";
	return p;
}

/** Method to generate a paragraph for a text field question has no endlabel
* @param id the id of the question
* @return p the paragraph as a string
* @author Philipp
*/
str generateParagraph(str id, str label, str formId){
	javaScriptAddGlobalVariable(formId, "var <id>Paragraph = document.createElement(\'p\');");
	str p = "<id>Paragraph.setAttribute(\"class\", \'<id>Paragraph\');
	<id>Paragraph.setAttribute(\"id\", <id>Paragraph);
	<id>Paragraph.appendChild(<id>Label);
	<id>Paragraph.appendChild(<id>);
	";
	return p;
}

/** Method to generate Question 
*/
private str generateQuestion(str formId, question:easyQuestion(str id, str labelQuestion, Type tp)){
	str label = generateQuestionLabel(formId, id, labelQuestion);
	if(tp == boolean()){	
		javaScriptAddGlobalVariable(formId, "var <id> = document.createElement(\"input\");");
		str attributes = specifyAttributesCheckbox(id);
		str endLabelCheckbox = createEndingLabel(formId, id);
		str paragraph = generateParagraph(id, label, attributes, endLabelCheckbox, formId);
		str cssLabel = cssEndLabels(id);
		appendToCssFile(formId, cssLabel);
		javaScriptAddCheckFunction(formId, "<id>DoTheCheck(cb)", tp);
		return "<attributes> <label> <endLabelCheckbox> <paragraph>
		<formId>.appendChild(<id>Paragraph);	
		 ";
	}else if(tp == money()){  // add the moment just a textfield
		javaScriptAddGlobalVariable(formId, "var <id> = document.createElement(\"input\");");
		str attributes = specifyAttributesNumeric(id);
		str paragraph = generateParagraph(id, label, formId);
		str cssLabel = cssEndLabels(id);
		appendToCssFile(formId, cssLabel);
		javaScriptAddCheckFunction(formId, "<id>CheckNumeric(cb)", tp);
		return "<attributes>
		<label>
		<paragraph>
		<formId>.appendChild(<id>Paragraph);
		 ";
	}else if(tp == integer()){ // add the moment just a textfield
		javaScriptAddGlobalVariable(formId, "var <id> = document.createElement(\"input\");");
		str attributes = specifyAttributesNumeric(id);
		str paragraph = generateParagraph(id, label, formId);
		str cssLabel = cssEndLabels(id);
		appendToCssFile(formId, cssLabel);
		javaScriptAddCheckFunction(formId, "<id>CheckNumeric(cb)", tp);
		return "<attributes> <label> <paragraph> <formId>.appendChild(<id>Paragraph);
		 ";
	}else if(tp == string()){
		javaScriptAddGlobalVariable(formId, "var <id> = document.createElement(\"input\");");
		str attributes = specifyAttributesTextField(id);
		str paragraph = generateParagraph(id, label, formId);
		return "<attributes>
		<label>
		<paragraph>
		<formId>.appendChild(<id>Paragraph);
		 ";
	}
	
}

private str generateQuestion(str formId, question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	str label = generateQuestionLabel(formId, id, labelQuestion);
	if(tp == money()){
		str paragraph = generateParagraph(id, label, formId);
		javaScriptAddGlobalVariable(formId, "var <id> = document.createElement(\"input\");");
		javaScriptAddEvaluateQuestion(formId, id, exp);
		str attributes = specifyAttributesCalculation(id);
		return "<attributes>
		<label>
		<paragraph>
		<formId>.appendChild(<id>Paragraph);
		";
	}else if(tp == integer()){
		println("in integer generate computed Question");
	}else{
		println("ERROR TYPE IS NOT MONEY NOR INTEGER");
	}	
}

str generateStatement(str formId, statement:ifStat(Expression exp, list[Body] thenPart)){
	println("EXP : <exp>");
	str evaluate = evaluateExp(exp, money());
	println("EVALUATE IS : <evaluate>");
	
	str checkBoxId = toString(getChildren(exp)[0]);
	list[str] children = [];
	list[str] thenPartString = [];
	for(s <- thenPart){
		thenPartString += generateBody(formId, s);
		visit (s) {
			case Question q : {
				children += q.id;
			}
		}		
	}
	if(size(getChildren(exp)) <= 1){ 
		javaScriptAddCheckStatementFunction(formId, checkBoxId, thenPartString, children);
		return "<checkBoxId>.setAttribute(\'onchange\',\"<checkBoxId>DoTheCheckWithStatement(this)\");";
	}else{
		// i need to get the expression   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		javaScriptAddCheckStatementFunction(formId, "hasSoldHouseValueCheck(cb)", thenPartString, evaluate,children);
		javaScriptAddCheckStatementFunction(formId, "boughtHouseValueCheck(cb)", thenPartString, evaluate,children);
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return "hasSoldHouse.setAttribute(\'onchange\',\"hasSoldHouseValueCheck(this)\");
		boughtHouse.setAttribute(\'onchange\',\"boughtHouseValueCheck(this)\");
		";
	}
}

public str generateBody(str id, Body body){
	if(getName(body) == "statement"){
		visit(body){
			case Statement s : {
				return "<generateStatement(id, s)> ";
			}
		}
	}
	visit(body){
		case Question q : {
			str temp = generateQuestion(id, q);
			return temp;
		}		
	}
}

public str generateQLForm(Program P){
	if(program(str id, list[Body] Body) := P){
		println("in generate JavaScriptForm");
		createQLOnHarddisk(id);
		str result = "\<!DOCTYPE html\>
		\<html\>
		\<head\>
		\<script src=\"<id>.js\"\> \</script\>
		\<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js\"\>\</script\>
		\<script src=\"http://malsup.github.com/jquery.form.js\"\>\</script\> 
		\<script src=\"gen_validatorv4.js\" type=\"text/javascript\"\> \</script\>
		\<link href=\"<id>.css\" rel=\"stylesheet\" type=\"text/css\"\>
		\</head\>
		\<body\>
		\<script\>
			createForm();
		\</script\>
		\</body\>
		\</html\>";	
		str functions = javaScriptCreateForm(id, Body);
		appendToHTMLFile(id, result);
		cssDiv(id);
		return result;
	}else{
		return "not possible to generate java script code";
	}
}

public str generateQLForm(str txt) = generateQLForm(load(txt));
