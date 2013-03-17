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
import template::PHP;
import template::StringTemplateHelper;


/** Method to generate the JavaScript code for a question label
* @param id the id of the question used for naming
* @param label the label text
* @return str a string with java script code
* @author Philipp
*/
str generateQuestionLabel(str formId, str id, str label){
	appendToJavaScriptFile(formId, "var <id>Label = document.createElement(\'label\');");  //create a global variable
	return "<id>Label.htmlFor = <id>; 
			'	<id>Label.innerHTML = <label>; ";
}

/** Method to generate the JavaScript code for the end part of a question
* @param id the id of the question used for naming
* @return str a string with java script code
* @author Philipp
*/
str createEndingLabel(str formId, str id){
	appendToJavaScriptFile(formId, "var <id>EndLabel = document.createElement(\'label\');"); //create a global variable
	return "<id>EndLabel.htmlFor = <id>; 
			'	<id>EndLabel.innerHTML = \"Yes\";
			'	<id>EndLabel.class = \"<id>EndClass\"; ";
}

/** Method to set the attributes of a checkBox in java script
* @param id the id of the question is used as id, name and value of the checkbox
* @return str a java code snipped as string
* @author Philipp
*/
private str specifyAttributesCheckbox(str id){
	return "<id>.setAttribute(\'type\',\"checkbox\");
			'	<id>.setAttribute(\'id\',<id>);
			'	<id>.setAttribute(\'name\',\'<id>\');
			'	<id>.setAttribute(\'onclick\',\"<id>DoTheCheck(this)\"); ";
}

/** Method to set the attributes of a numeric textfield in java script
* @param id the id of the question is used as id, name and value of the textfield
* @return str a java code snipped as string
* @author Philipp
*/
str specifyAttributesNumeric(str id){
	return "<id>.setAttribute(\'type\',\"number\");
			'	<id>.setAttribute(\'id\',<id>); 
			'	<id>.setAttribute(\'name\',\'<id>\');
			'	<id>.setAttribute(\'onchange\',\"<id>CheckNumeric(this)\"); ";
}

/** Method to set the attributes of a textfield that is the result of a calculation in java script
* @param id the id of the question is used as id, name and value of the textfield
* @return str a java code snipped as string
* @author Philipp
*/
str specifyAttributesCalculation(str id){
	return "<id>.setAttribute(\'type\',\"text\");
			'	<id>.setAttribute(\'id\',<id>);
			'	<id>.setAttribute(\'name\',\'<id>\');
			'	<id>.setAttribute(\'readOnly\',\'readonly\');
			'	<id>.setAttribute(\'onchange\',\"<id>Calculation(this)\"); ";
}

/** Method to set the attributes of a textfield in javascript
* @param id the id of the question is used as id, name and value of the textfield
* @return str a java code snipped as string
* @author Philipp
*/
str specifyAttributesTextField(str id){
	return "<id>.setAttribute(\'type\',\"text\");
			'	<id>.setAttribute(\'id\',<id>);
			'	<id>.setAttribute(\'name\',\'<id>\'); ";
}

/** Method to generate a paragraph for a boolean question has as endlabel Yes or No
* @param id the id of the boolean question
* @return p the paragraph as a string
* @author Philipp
*/
str generateParagraph(str id, str att, str lab, str endlab, str formId){
	appendToJavaScriptFile(formId, "var <id>Paragraph = document.createElement(\'p\');");  //create a global variable
	return "<id>Paragraph.setAttribute(\"class\", \'<id>Paragraph\');
			'	<id>Paragraph.setAttribute(\"id\", <id>Paragraph);
			'	<id>Paragraph.appendChild(<id>Label);
			'	<id>Paragraph.appendChild(<id>);
			'	<id>Paragraph.appendChild(<id>EndLabel); ";
}

/** Method to generate a paragraph for a text field question has no endlabel
* @param id the id of the question
* @return p the paragraph as a string
* @author Philipp
*/
str generateParagraph(str id, str label, str formId){
	appendToJavaScriptFile(formId, "var <id>Paragraph = document.createElement(\'p\');");  //create a global variable
	return "<id>Paragraph.setAttribute(\"class\", \'<id>Paragraph\');
			'	<id>Paragraph.setAttribute(\"id\", <id>Paragraph);
			'	<id>Paragraph.appendChild(<id>Label);
			'	<id>Paragraph.appendChild(<id>); ";
}

/** Method to generate Question 
*/
private str generateQuestion(str formId, question:easyQuestion(str id, str labelQuestion, Type tp)){
	createColumnInTable(formId, id, tp);
	appendToJavaScriptFile(formId, "var <id> = document.createElement(\"input\");");  //global variable
	createPostValuePHP(formId, id);
	str label = generateQuestionLabel(formId, id, labelQuestion);
	if(tp == boolean()){			
		str attributes = specifyAttributesCheckbox(id);
		str endLabelCheckbox = createEndingLabel(formId, id);
		str paragraph = generateParagraph(id, label, attributes, endLabelCheckbox, formId);
		cssEndLabels(formId, id);
		javaScriptAddCheckFunction(formId, "<id>DoTheCheck(cb)", tp);
		return "<attributes>
				'<label>
				'<endLabelCheckbox>
				'<paragraph>
				'<formId>.appendChild(<id>Paragraph); 
				'";
	}else if(tp == money() || tp == integer()){  
		str attributes = specifyAttributesNumeric(id);
		str paragraph = generateParagraph(id, label, formId);
		cssEndLabels(formId, id);
		javaScriptAddCheckFunction(formId, "<id>CheckNumeric(cb)", tp);
		return "<attributes>
				'<label>
				'<paragraph>
				'<formId>.appendChild(<id>Paragraph);
				'";
	}else if(tp == string()){
		str attributes = specifyAttributesTextField(id);
		str paragraph = generateParagraph(id, label, formId);
		cssEndLabels(formId, id);
		return "<attributes>
				'<label>
				'<paragraph>
				'<formId>.appendChild(<id>Paragraph);
				'";
	}
	
}

/** Method to generate a computed question in JavaScript
* @param formId the name of the questionare
* @param question the computed question
* @return str a string with a javascript code snipped
* @author Philipp
*/
str generateQuestion(str formId, question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	createColumnInTable(formId, id, tp);			// create a column in the database
	appendToJavaScriptFile(formId, "var <id> = document.createElement(\"input\");");	// 
	createPostValuePHP(formId, id);
	str label = generateQuestionLabel(formId, id, labelQuestion);
	if(tp == money() || tp == integer()){
		str paragraph = generateParagraph(id, label, formId);		
		javaScriptAddEvaluateQuestion(formId, id, exp, tp);
		str attributes = specifyAttributesCalculation(id);
		return "<attributes>
				'<label>
				'<paragraph>
				'<formId>.appendChild(<id>Paragraph); ";
	}else{
		println("ERROR TYPE IS NOT MONEY NOR INTEGER");
	}	
}

/** Method to
*/
str generateStatement(str formId, statement:ifStat(Expression exp, list[Body] thenPart), list[Body] body){
	list[tuple[str id,Type tp]] idAndType = getExpressionTypeGenerate(exp, body);
	str evaluate = evaluateExp(exp, idAndType[0].tp);	
	str checkBoxId = toString(getChildren(exp)[0]);
	println("checkbox ID IS : <checkBoxId>");
	tuple[list[str] thenPartString,list[str] children] thenChildren = getThenPartIfElse(formId, thenPart, body);
	if(size(getChildren(exp)) <= 1){   // for boolean
		javaScriptAddCheckStatementFunction(formId, checkBoxId, thenChildren.thenPartString, thenChildren.children);
		return "<checkBoxId>.setAttribute(\'onchange\',\"<checkBoxId>DoTheCheckWithStatement(this)\");
				'";
	}else{
		list[str] ids = getChildrenIds(exp);
		str result = "";
		for(k <- ids){
			javaScriptAddCheckStatementFunction(formId, "<k>ValueCheck(cb)", thenChildren.thenPartString, evaluate, thenChildren.children);
			result += "<k>.setAttribute(\'onchange\',\"<k>ValueCheck(this)\");
						'";
		}
		return result;
	}
}

str generateStatement(str formId, statement:ifElseStat(Expression exp, list[Body] thenPart, list[Body] elsePart), list[Body] body){
	println("in generate if else <exp>");
	if(size(getChildren(exp)) > 1){
		list[tuple[str id,Type tp]] idAndType = getExpressionTypeGenerate(exp, body);
		str check = evaluateExp(exp, idAndType[0].tp);
		println(check);
		if(idAndType[0].tp == integer()) return evaluateExp(exp,idAndType[0].tp,env);
    	else{ 
    		list[str] checkBoxIds = [];
    		for(s <- exp){
    			visit(s){
    				case Expression id2:{
    					println("ID : <getChildren(id2)>");
    					checkBoxIds += toString(getChildren(id2)[0]);
    				}
    			}
    		}
    		tuple[list[str] thenPartString, list[str] children] thenChildren = getThenPartIfElse(formId, thenPart, body);
    		tuple[list[str] elsePartString, list[str] childrenElse] elseChildren = getElsePartIfElse(formId, elsePart, body);
			str elseOneString = javaScriptaddIfElseStatement(formId, checkBoxIds, thenChildren.thenPartString, elseChildren.elsePartString, thenChildren.children, elseChildren.childrenElse, check);
			return "<elseOneString>
					'<for(c <- checkBoxIds){> 
					'<c>.setAttribute(\'onclick\',\"<c>IfElseStatement(this)\"); 
					'<}>
					'";
    	}
	}else{			// for boolean
		list[tuple[str id,Type tp]] idAndType = getExpressionTypeGenerate(exp, body);
		str check = evaluateExp(exp, idAndType[0].tp);		
		println("CHECK IS : <check>");
    	if(idAndType[0].tp == integer()) return checkIntExp(exp,idAndType[0].tp,env);
    	else{
    		str checkBoxId = toString(getChildren(exp)[0]);
    		tuple[list[str] thenPartString, list[str] children] thenChildren = getThenPartIfElse(formId, thenPart, body);
    		tuple[list[str] elsePartString, list[str] childrenElse] elseChildren = getElsePartIfElse(formId, elsePart, body);
			str elseOneString = javaScriptaddIfElseStatement(formId, checkBoxId, thenChildren.thenPartString, elseChildren.elsePartString, thenChildren.children, elseChildren.childrenElse);
			return "<elseOneString>
					'	<checkBoxId>.setAttribute(\'onchange\',\"<checkBoxId>IfElseStatementBoolean(this)\");
					'";  
    		}
	}	
}

/** Method to get the names of childrens from an expression
* @param exp the Expression
* @return list[str] a list with names
* @author Philipp
*/
list[str] getChildrenIds(Expression exp){
	list[str] childrensIds = [];		// empty list to save children ids
	top-down visit(exp){				// visit the expression
		case Expression e : {			 
			if(getName(e) == "id") childrensIds += toString(getChildren(e)[0]);
		}
	}
	return childrensIds;
}

/** Method to generate the QL program in javascript
* @param id the name of the questionaire
* @param body the body of the ql
* @return str a code snipped with javascript code
* @author Philipp
*/
public str generateBody(str id, Body body, list[Body] complete){
	if(getName(body) == "statement"){			// if the questionaire starts with a statement
		visit(body){							// visit the body
			case Statement s : return "<generateStatement(id, s, complete)> "; 		// case Statement call generateStatement
		}
	}
	visit(body){								// if the questionaire starts with a question
		case Question q : return generateQuestion(id, q);		// case Question call generateQuestion
	}
}

/** Method to
*/
public void generateQLForm(Program P){
	if(program(str id, list[Body] Body) := P){
		createQLOnHarddisk(id);  			// create empty files on harddisk 
		generateDatabaseCode(id); 			// generate the Database 
		str result = "\<!DOCTYPE html\>
		'\<html\>
		'	\<head\>
		'	\<script src=\"<id>.js\"\> \</script\>
		'	\<link href=\"<id>.css\" rel=\"stylesheet\" type=\"text/css\"\>
		'	\</head\>
		'	\<body\>
		'	\<script\>
			'	createForm();
		'	\</script\>
		'	\</body\>
		'\</html\>";	
		javaScriptCreateForm(id, Body);		// create the JavaScript File
		appendToHTMLFile(id, result);		// append code to HTML File
		cssDiv(id);							// create CSS property for HTML div tag
		insertValueInDatabase(id,Body);		// 
		appendToPHPFile(id, " mysql_close($conn); ?\>");   //close tag
	}else{
		return "not possible to generate java script code";
	}
}

public void generateQLForm(str txt) = generateQLForm(load(txt));
