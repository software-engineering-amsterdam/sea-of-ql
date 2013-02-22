@contributor{George Marmanidis -geo.marmani@gmail.com}
//Maybe split it
module lang::ql::compiler::GenerateHTMLForm

import lang::ql::ast::AST;
import lang::ql::compiler::ExtractDependencies;

public str generateHTMLForm(str ident,list[FormBodyItem] bodyItems){
	
	return
	   "\<html\>
	   '   \<head\> \<title\> <ident> \</title\>
	   '      \<script type=\"text/javascript\" src=\"<ident>.js\"\>\</script\>
	   '      \<script type=\"text/javascript\" src=\"extFuncs.js\"\>\</script\>
	   '   \</head\>
	   '
	   '   \<body onload=\"onLoad()\"\>
	   '      \<form name=\"<ident>\" method=\"POST\" onsubmit=\"return formValidate(this)\"\>
	   '        <generateHTMLFormBody(bodyItems,"stats0")>
	   '        \<input type=\"submit\"\>
	   '      \</form\>
	   '   \</body\>
	   '\</html\>";
}

str generateHTMLFormBody(list[FormBodyItem] formItems,str refID){
    str code="";
	
	code+="\<div id=\"<refID>\"\>\n";
    
    for(x <-formItems){
   	   if(question(Question itemQuestion) := x){
   	   	    code+="   <generateHTMLQuestion(itemQuestion,refID)>";
   	   }
   	   else if(conditionalStatement(ConditionalStatement itemCondStatement):=x){
	   	        code+="   <generateHTMLCondBody(itemCondStatement)>";
     	   }
    	}
    	
     code+="\</div\>\n";
     return code;
}

str generateHTMLCondBody(x:ifCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[FormBodyItem] elseQuestions)){
    str code="";
    code+=generateHTMLFormBody(ifQuestions,"ifStats<x@ref>");
    code+=generateHTMLFormBody(elseQuestions,"elseStats<x@ref>");
    return code;
}

str generateHTMLCondBody(x:simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions))=
	generateHTMLFormBody(ifQuestions,"ifStats<x@ref>");
    
str generateHTMLCondBody(x:ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestions)){
    str code="";
    code+=generateHTMLFormBody(ifQuestions,"ifStats<x@ref>");
    
    for(elseBranch <- elseifBranch){
        code+=generateHTMLCondBody(elseBranch,"elseIfStats<elseBranch@ref>");
    }
	 
    code+=generateHTMLFormBody(elseQuestions,"elseStats<x@ref>");
    return code;
}

str generateHTMLCondBody(x:elseif(Expr ifExpression,list[FormBodyItem] elseQuestions),str refID)=
    generateHTMLFormBody(elseQuestions,refID);

str generateHTMLQuestion(simpleQuestion(str questionId,str questionLabel,Type questionType),str refID){
    return questionType==boolean()
    	   ? generateHTMLBooleanInput(questionLabel,questionId,refID) 
    	   : generateHTMLTextInput(questionLabel,questionId,refID);
}
	
str generateHTMLQuestion(computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),str refID){
    return questionType==boolean()
    	   ? generateHTMLBooleanInputComputed(questionLabel,questionId,refID)
           : generateHTMLTextInputComputed(questionLabel,questionId,refID);
}

str generateHTMLTextInput(str label,str varName,str id)=
    "<label> : \<INPUT type=\"text\" name=\"<varName>\" id=\"<varName>\" onchange=\"<varName>Trigger()\" \> \<br\>\n";
		   
str generateHTMLBooleanInput(str label,str varName,str id)=
    "<label> : True\<INPUT type=\"radio\" name=\"<varName>\" id=\"<varName>\" value=\"true\" onchange=\"<varName>Trigger()\"\> 
	           False\<INPUT type=\"radio\" name=\"<varName>\" id=\"<varName>\" value=\"false\" onchange=\"<varName>Trigger()\"\>\<br\>\n";
	
str generateHTMLTextInputComputed(str label,str varName,str id)=
    "<label> : \<INPUT type=\"text\" name=\"<varName>\" id=\"<varName>\" 
    			value=\"\" readonly=\"readonly\"  \> \<br\>\n";

str generateHTMLBooleanInputComputed(str label,str varName,str id)=
    "<label> : True\<INPUT type=\"radio\" name=\"<varName>\" id=\"<varName>\" value=\"true\" readonly=\"readonly\"\> 
	           False\<INPUT type=\"radio\" name=\"<varName>\" id=\"<varName>\" value=\"false\" readonly=\"readonly\"\>\<br\>\n";
		
