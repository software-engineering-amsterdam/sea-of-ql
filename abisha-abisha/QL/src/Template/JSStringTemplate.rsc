module Template::JSStringTemplate

import syntax::Abstract;
import load::Load;
import IO;
import Prelude;
import util::Math;
import Template::CSS;

//------"Main Method" 
public void createQLFormUI(Form P)
{
	if(form(str qId, list[Body] stats):=P)
	{
		// ----- JS
		generateAndSaveJS(qId,stats);
		// ----- HTML
		generateAndSaveHTML(qId);
		// ----- CSS
		generateAndSaveCSS(qId);
	}
	else
	{
		return "error with form! ";
	}
}

private void generateAndSaveJS(str id, list[Body] Body)
{
	// deleted createSekeleton functions, appendToFile now receives a String, creates the file directly with the String.
	//If input element loses focus, validation starts, if not valid input, user must correct before answering other questions 
	str javaScriptContentString ="";
	javaScriptContentString += generateNeededVars();
	javaScriptContentString += createJSOnLoadFunction();
	javaScriptContentString += generateJSFormGeneratorMethod(id,Body);
	javaScriptContentString += generateComputeValueChangeMethod();
	javaScriptContentString += generateNeededFunctions();

	writeFile(|file:///C:/queL/|+"<id>.js",javaScriptContentString);
}
//generate JS function which generates the form on window load
public str generateJSFormGeneratorMethod(str id, list[Body] Body)
{
	str f = "function generateQuestionnaireContent()
	{ 
    '	<id>QuestionnaireContainer = document.createElement(\"div\");
    '	<id>QuestionnaireContainer.setAttribute(\'name\',\'<id>QuestionnaireContainer\'); 
    '	<id>QuestionnaireContainer.setAttribute(\'id\',\"<id>QuestionnaireContainer\");
    '	<id>QuestionnaireContainer.setAttribute(\'class\',\'questionnaireContainer\');
    '	<id> = document.createElement(\"form\"); 
    '	<id>.setAttribute(\'method\',\"post\");
    '	<id>.setAttribute(\'action\',\"<id>.php\"); 
    '	<id>.setAttribute(\'name\',\'<id>\'); 
    '	<id>.setAttribute(\'id\',\"<id>\");
    '	<for (s <- Body) 
    	{
    		> <generateQuestionnaireBodyItem(id,s, Body)> < 
    	} >
    '	<generateSubmitButton(id)>
    '	<id>.appendChild(<id>Submit);
    '	<id>QuestionnaireContainer.appendChild(<id>);
    '	document.getElementsByTagName(\'body\')[0].appendChild(<id>QuestionnaireContainer);
    '	evaluateExpressions();
	'	evaluateStatementStatuses();
	'	evaluateComputedQuestions();
    '} ";
     
     return f;
   
}
// ---- GENERATE QUESTIONNAIRE ITEMs
private str generateQuestionnaireBodyItem(str id, Body stats, list[Body] Body)
{
	if(getName(stats)=="statement")
	{
		str temp= statementForJavaScript(id, stats.statement);
		return temp ;
	}
	else if(getName(stats)=="question")
	{
		str temp= questionForJavaScript(id, stats.question) ; 
		return temp;
	}
}
// ------------ QUESTIONS
// ----- uncomputed question 
private str questionForJavaScript(str formName, question:uncomputedQuestion(str id, str label,Type tp))
{	
	str returnValue = "
		'	var <id>QuestionContainer = createQuestionContainer();
		'	var <id>Label = createQuestionLabel(<id>,<label>); 
		'	<id>QuestionContainer.appendChild(<id>Label);
		'	var <id>ValueContainer = createQuestionValueContainer(<id>,<label>);  
		'	var <id> = createQuestionInput(\"<id>\",\"<getName(tp)>\");
		'	<generateInputIdToValueMapping(id ,"0")>
		'	<id>ValueContainer.appendChild(<id>);
		'	<id>QuestionContainer.appendChild(<id>ValueContainer);
		'	<formName>.appendChild(<id>QuestionContainer);";
	return returnValue;
}
// ----- computed question skeleton
private str questionForJavaScript(str formName, question:computedQuestion(str id, str label,Type tp, Expression exp))
{
	str expressionString = expressionToString(exp,tp);
	
	str returnValue = "
		'	var <id>QuestionContainer = createQuestionContainer();
		'	var <id>Label = createQuestionLabel(<id>,<label>); 
		'	<id>QuestionContainer.appendChild(<id>Label);
		'	var <id>ValueContainer = createQuestionValueContainer(\"<id>\",<label>);  
		'	var <id> = createQuestionInput(\"<id>\",\"<getName(tp)>\");
		'	<id>.disabled = true;
		'	<generateInputIdToValueMapping("<id>" ,"0")>
		'	<generateInputIdToExpressionMapping("<id>" ,expressionString)>
		'	computedQuestionIds.push(\"<id>\");
		'	<id>ValueContainer.appendChild(<id>);
		'	<id>QuestionContainer.appendChild(<id>ValueContainer);
		'	<formName>.appendChild(<id>QuestionContainer);
		";
	return returnValue;
}
// ----------- VALUE MAPPING FOR EVALUATION
private str generateStatementToExpressionMapping(str statementId, str exp)
{
	str returnValue = "statementIdToStateMap[\"<statementId>\"] = eval(<exp>);";
	return returnValue;
}

private str generateInputIdToValueMapping(str inputId, str val)
{
	str returnValue = "idToValueMap[\"<inputId>\"]= <val>;";
	return returnValue;
}
// update computed value on change 
private str generateComputeValueChangeMethod()
{
	str result = "function computeChange(id,value)
	{
	'	idToValueMap[id]= value;
	'	evaluateExpressions();
	'	evaluateStatementStatuses();
	'	evaluateComputedQuestions();
	}\n"; 
	return result; 
}
// generate the questions
private str generateComputedQuestionsFunction()
{
	str result ="function evaluateComputedQuestions()
	{
		for(var i=0; i\<computedQuestionIds.length;i++)
		{
			var computedQuestionId = computedQuestionIds[i];
			var compEval = eval(idToExpressionMap[computedQuestionId]);
			idToValueMap[computedQuestionId] = compEval;
			if(document.getElementById(computedQuestionId).type ==\"checkbox\")
			{
				document.getElementById(computedQuestionId).checked = idToValueMap[computedQuestionId];
			}
			else
			{
				document.getElementById(computedQuestionId).value = idToValueMap[computedQuestionId];
			}
		}
	}\n";
	return result;
}
//expression evaluation 
private str generateEvaluateExpressionsFuction()
{ 
	str result = "function evaluateExpressions()
	{
	'	for (var key in idToExpressionMap) 
		{
	    	idToValueMap[key] = eval(idToExpressionMap[key]);
	    }
	}";
	return result;
}

private str generateStatementStatusChangeFunction()
{
	str result ="function evaluateStatementStatuses()
	{
	'	for (var key in statementIdToStateMap) 
		{
    		idToValueMap[key] = eval(idToExpressionMap[key]);
    		var statementContainer = document.getElementById(key);
    		var ifBlock = statementContainer.getElementsByClassName(\"ifBlockContainer\")[0];
    		var elseBlock = statementContainer.getElementsByClassName(\"elseBlockContainer\")[0];
    		
    		if(idToValueMap[key]==true)
    		{   
    			if(ifBlock.parentNode.parentNode.className ==\"ifBlockContainer\" || ifBlock.parentNode.parentNode.className ==\"elseBlockContainer\")
    			{
	    			var ifParent = ifBlock.parentNode.parentNode.id;// == \'visible\';
	    			var elseParent = ifBlock.parentNode.parentNode.id;// == \'visible\';
	    			if (document.getElementById(ifParent).style.visibility == \"hidden\" || document.getElementById(elseParent).style.visibility == \"hidden\")
	    			{
	    				return;
	    			}	    				
   				}	
				ifBlock.style.visibility=\"visible\";
				if(elseBlock != undefined)
				{
					elseBlock.style.visibility=\"hidden\";
				}
    		}
    		else
    		{
    			ifBlock.style.visibility=\"hidden\";
    			for(i=0; i\<ifBlock.getElementsByClassName(\"ifBlockContainer\").length; i++)
    			{ 
    				ifBlock.getElementsByClassName(\"ifBlockContainer\")[i].style.visibility=\"hidden\";
    			}
    			
    			
    			if(elseBlock != undefined)
    			{
					elseBlock.style.visibility=\"visible\";
				}
    		}
		}
	}";
	return result;
}

private str generateInputIdToExpressionMapping(str id, str exp)
{
	str returnValue = "idToExpressionMap[\"<id>\"] = \"<exp>\";
	 "; 
	return returnValue;
}
//-------------------------IF ELSE BLOCK
// ----IF statement
private str statementForJavaScript(str formName, statement:ifStat(Expression exp, list[Body] stats)) 
{
	str expressionString = expressionToString(exp,boolean());
	//generate random number because statements do not have id's
	int statementId = arbInt(1000);
	str returnValue = "<generateConditionalStatementBlock(formName,false,statementId)> 
	'	<formName>.appendChild(statContainer<statementId>);
	'	<generateInputIdToValueMapping("statContainer"+toString(statementId) ,"\"false\"")> 
	'	<generateStatementToExpressionMapping("statContainer"+toString(statementId),toString("eval(\"<expressionString>\")"))>
	'	<generateInputIdToExpressionMapping("statContainer"+toString(statementId) ,expressionString)>
	";
	 for (s <- stats)
	 {
	 	returnValue = returnValue + generateQuestionnaireBodyItem("ifBlockContainer"+toString(statementId),s,stats); 
	 } 
	return returnValue; 
}

// ----IF ELSE statement
private str statementForJavaScript(str formName, statement:ifElseStat(Expression exp, list[Body] ifStats,list[Body] elseStats))
{
	str expressionString = expressionToString(exp,boolean()) ;
	//generate random number because statements do not have id's
	int statementId = arbInt(1000);
	str returnValue = "
	'	<generateConditionalStatementBlock(formName,true,statementId)>
	'	<formName>.appendChild(statContainer<statementId>);
	'	<generateInputIdToValueMapping("statContainer"+toString(statementId) , toString("eval(\"<expressionString>\")"))> 
	'	<generateStatementToExpressionMapping("statContainer"+toString(statementId),"\"<expressionString>\"")>
	'	<generateInputIdToExpressionMapping("statContainer"+toString(statementId) ,expressionString)>
	"; 
	//if statement body items
	for (s <- ifStats) 
	{
		returnValue = returnValue   +  generateQuestionnaireBodyItem("ifBlockContainer"+toString(statementId),s,ifStats); 
	} 
	  //else statement body items
	for (s <- elseStats) 
	{
		returnValue = returnValue + generateQuestionnaireBodyItem("elseBlockContainer"+toString(statementId),s,elseStats); 
	} 
	returnValue = returnValue  + "statContainer<statementId>.appendChild(elseBlockContainer<toString(statementId)>); ";
	 
	return returnValue;
}
// ---- GENERATE WHEATHER IF OR ELSE BLOCK
private str generateConditionalStatementBlock(str formName, bool hasElseBlock, int ifStatementId)
{
	str returnValue ="
	'	var statContainer<ifStatementId> = document.createElement(\"div\");
	'	statContainer<ifStatementId>.setAttribute(\"class\", \"statContainer\");
	'	statContainer<ifStatementId>.setAttribute(\"id\", \"statContainer<ifStatementId>\");
	'	var ifBlockContainer<ifStatementId> = document.createElement(\"div\");
	'	ifBlockContainer<ifStatementId>.setAttribute(\"class\", \"ifBlockContainer\");
	'	ifBlockContainer<ifStatementId>.setAttribute(\"id\", \"ifBlockContainer<ifStatementId>\");
	'	statContainer<ifStatementId>.appendChild(ifBlockContainer<ifStatementId>);";
	
	if(hasElseBlock)
	{
		returnValue = returnValue +"
		'	var elseBlockContainer<ifStatementId> = document.createElement(\"div\");
		'	elseBlockContainer<ifStatementId>.setAttribute(\"class\", \"elseBlockContainer\");
		'	elseBlockContainer<ifStatementId>.setAttribute(\"id\", \"elseBlockContainer<ifStatementId>\");
		'	statContainer<ifStatementId>.appendChild(elseBlockContainer<ifStatementId>);";
	}
	returnValue = returnValue + "<formName>.appendChild(statContainer<ifStatementId>);";
	return returnValue;
}
//--------------VALUE EVALUATION
private str expressionToString(Expression exp,Type tp)
{
	str returnValue = evaluateExp(exp, tp);
	return returnValue;
}
// ---- UNARY
private str evaluateExp(exp:id, Type req) 
{
	value e1 = getChildren(exp)[0];
	//check to return in right terminal format 
	if(getName(exp) == "strCon")
	{
  		return "<escape(toString(e1),("\"" : "\'"))>";
  	}
  	else if(getName(exp) == "id")
  	{
  		return  "<escape("idToValueMap[\"<toString(e1)>\"]",("\"" : "\'"))>";
  	}
   return "<e1>";
}

private str evaluateExp(exp:pos, Type req) 
{
	value e1 = getChildren(exp)[0];
	println("pos: "+toString(e1));
  	return "+<e1>";
}

private str evaluateExp(exp:neg, Type req) 
{
	value e1 = getChildren(exp)[0];
	return "eval(-<e1>)";
}
private str evaluateExp(exp:not, Type req) 
{
	str e1 = getChildren(exp)[0];
	return "eval(!<e1>)";
}
// ----BINARY
private str evaluateExp(exp:sub(Expression E1, Expression E2), Type req) 
{
	str e1 = evaluateExp(E1, money());
	str e2 = evaluateExp(E2, money());
	return "eval(<e1> - <e2>)";
}

private str evaluateExp(exp:add(Expression E1, Expression E2), Type req) 
{
	str e1 = evaluateExp(E1, money());
	str e2 = evaluateExp(E2, money());
  	return "eval(<e1> + <e2>)";
}

private str evaluateExp(exp:mul(Expression E1, Expression E2), Type req) 
{
  	str e1 = evaluateExp(E1, money());
  	str e2 = evaluateExp(E2, money());
  	return "eval(<e1> * <e2>)";
}

private str evaluateExp(exp:div(Expression E1, Expression E2), Type req) 
{
	str e1 = evaluateExp(E1, money());
  	str e2 = evaluateExp(E2, money());
  	return "eval(<e1> / <e2>)";
}
private str evaluateExp(exp:lt(Expression E1, Expression E2), Type req) 
{
	str e1 = evaluateExp(E1, boolean());
  	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> \< <e2>)";
}

private str evaluateExp(exp:leq(Expression E1, Expression E2), Type req) 
{
	str e1 = evaluateExp(E1, boolean());
	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> \<= <e2>)";
}

private str evaluateExp(exp:gt(Expression E1, Expression E2), Type req) 
{
  	str e1 = evaluateExp(E1, boolean());
  	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> \> <e2>)";
}

private str evaluateExp(exp:geq(Expression E1, Expression E2), Type req) 
{
  	str e1 = evaluateExp(E1, boolean());
  	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> \>= <e2>)";
}
private str evaluateExp(exp:eq(Expression E1, Expression E2), Type req) 
{
  	str e1 = evaluateExp(E1, boolean());
  	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> == <e2>)";
}

private str evaluateExp(exp:neq(Expression E1, Expression E2), Type req) 
{
  	str e1 = evaluateExp(E1, boolean());
  	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> != <e2>)";
}

private str evaluateExp(exp:and(Expression E1, Expression E2), Type req) 
{
  	str e1 = evaluateExp(E1, boolean());
  	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> && <e2>)";
}

private str evaluateExp(exp:or(Expression E1, Expression E2), Type req) 
{
  	str e1 = evaluateExp(E1, boolean());
  	str e2 = evaluateExp(E2, boolean());
  	return "eval(<e1> || <e2>)";
}
//---binary
private str evaluateExp(exp:boolCon, Type req) 
{
  	str e1 = getChildren(exp)[0];
  	return "<e1>";
}

private str evaluateExp(exp:moneyCon, Type req) 
{
  	str e1 = getChildren(exp)[0];
  	return "<e1>";
}

private str evaluateExp(exp:strCon, Type req) 
{
  	str e1 = getChildren(exp)[0];
  	return "<e1>";
}
//----------------- GENERATE FILES & SKELETONS
public str generateSubmitButton(str qId)
{
	return result ="
	'	<qId>Submit = document.createElement(\"input\");
	'	<qId>Submit.setAttribute(\"type\", \"submit\");
	'	<qId>Submit.setAttribute(\"value\", \"submit\");";
}

public void generateAndSaveHTML(str qId)
{
	str result ="\<!DOCTYPE html\>
	'	\<html\>
    '    \<head\>
    '    \<script src=\"<qId>.js\"\> \</script\>
    '    \<link href=\"<qId>.css\" rel=\"stylesheet\" type=\"text/css\"\>
    '    \</head\>
    '    \<body\>
	
    '    \</body\>
    '	\</html\>";    
	writeFile(|file:///C:/queL/|+"<qId>.html",result);
}
//onload called when html document loaded
public str createJSOnLoadFunction()
{
	str result ="window.onload = function() 
	{ 
	'	generateQuestionnaireContent();
	};\n ";
	return result;
}
//generate global vars to save state
private str generateNeededVars()
{
	str result ="var statementIdToStateMap= {};
	'	var idToValueMap = {};
	'	var idToExpressionMap = {};
	'	var computedQuestionIds = new Array();
	'	var moneyRegex = /^\\d+(?:\\.\\d\\d?)?$/;
	'	var intRegex = /[^0-9\\.]/g;

	\n";
	return result;
}
// GENERATE ALL JAVASCRIPT HELPER FUNCTIONS
private str generateNeededFunctions()
{
	str result = "";
	result += generateQuestionContainerCreationFunction();
	result += generateQuestionLabelCreationFunction();
	result += generateQuestionValueContainerCreationFunction();
	result += generateQuestionInputCreationFunction();
	result += generateEvaluateExpressionsFuction();
	result += generateStatementStatusChangeFunction();
	result += generateComputedQuestionsFunction();
	return result;
}

private str generateQuestionContainerCreationFunction()
{
	str result ="function createQuestionContainer()
	{
	'	var returnValue = document.createElement(\"div\");
 	'	returnValue.setAttribute(\"class\", \"questionContainer\"); 
 	'	return returnValue;
 	}\n";
 	return result;
}
// create the labels
private str generateQuestionLabelCreationFunction()
{
	str result ="function createQuestionLabel(id,label)
	{
	'	var returnValue = document.createElement(\"div\");
 	'	returnValue.setAttribute(\"class\", \"questionLabel\"); 
 	'	returnValue.innerHTML = label;
 	'	return returnValue;
 	}\n";
 	return result; 
}

private str generateQuestionValueContainerCreationFunction()
{
	str result ="function createQuestionValueContainer(id,label)
	{
	'	var returnValue = document.createElement(\"div\");
 	'	returnValue.setAttribute(\"class\", \"questionValueContainer\");
 	'	return returnValue;
 	} \n";
 	return result;
}

private str generateQuestionInputCreationFunction()
{
	str result ="function createQuestionInput(id,type)
	{
	'	var returnValue = document.createElement(\"input\");
 	'	returnValue.setAttribute(\"type\", getInputType(type));
 	'	returnValue.setAttribute(\"id\", id);
 	'	returnValue.setAttribute(\"name\", id);
 	'	returnValue.setAttribute(\"class\", \"questionInput\");
 		returnValue.onblur =function()
 		{
		if(!validateInputValue(this.value,type))
		{
			this.focus();
			return;
		}
		
	}
	returnValue.onchange = function()
	{
		if(type==\"boolean\")
		{
			propagateValueChange(this.id,this.checked,type);
		}
		else
		{
		 	propagateValueChange(this.id,this.value,type); 
		}
	}
 	'	return returnValue;
 	} \n";  
 	result += generateGetQuestionInputTypeFunction();
	result += generateQuestionInputTypeValidator();
	result +=  generateQuestionValuePropagator();
	return result;
}

private str generateGetQuestionInputTypeFunction()
{
	str result ="function getInputType(type)
	{
		return type == \"boolean\" ? \"checkbox\" : \"text\";
 	} \n";
 	return result; 
}

private str generateQuestionInputTypeValidator()
{
	str result ="function validateInputValue(value,type)
	{
		if(type== \"money\")
		{
			if(value.match(moneyRegex) == null)
			{
			' 	alert(\"error! value should be money\");
			' 	return false;
			}
		}
		else if(type== \"integer\")
		{
			if (value != value.replace(intRegex,\'\')) 
			{
			'	alert(\"please type in a valid number\");
			' 	return false; 
			} 
		}
		return true;
	}\n ";
	return result;
}

private str generateQuestionValuePropagator()
{
	str result = "function propagateValueChange(id,value,type)
	{
		computeChange(id,value);		
	} \n";
	return result;		
}

public void generateQLForm(str txt)=createQLFormUI(load(txt));