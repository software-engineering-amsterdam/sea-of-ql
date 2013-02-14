module lang::ql::compiler::GenerateHTMLForm

import lang::ql::ast::AST;

anno str ConditionalStatement@ref;
anno str ElseIf@ref;
anno str FormBodyItem@ref;

public str generateHTMLForm(str ident,list[FormBodyItem] bodyItems){
			   
	return
	   "\<form name=\"<ident>\" method=\"POST\" \>
	   ' <generateHTMLFormBody(bodyItems,"stats0")>
	   '\</form\>";
}

str generateHTMLFormBody(list[FormBodyItem] formItems,str refID){
    str code="";
	
	code+="\<div id=\"<refID>\"\>\n";
    
    for(x <-formItems){
   	   if(question(Question itemQuestion) := x){
   	   	    code+=generateHTMLQuestion(itemQuestion,refID);
   	   }
   	   else if(conditionalStatement(ConditionalStatement itemCondStatement):=x){
	   	        code+=generateHTMLCondBody(itemCondStatement);
     	   }
    	}
    	
     code+="\</div\>\n";
     return code;
}

str generateHTMLCondBody(x:ifCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[FormBodyItem] elseQuestions)){
    str code="";
    //expression
	    
    code+=generateHTMLFormBody(ifQuestions,"ifStats<x@ref>");
    code+=generateHTMLFormBody(elseQuestions,"elseStats<x@ref>");
    return code;
}

str generateHTMLCondBody(x:simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions)){
    str code="";
	 
    //expression
    code+=generateHTMLFormBody(ifQuestions,"ifStats<x@ref>");
    return code;
}

str generateHTMLCondBody(x:ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestions)){
    str code="";
    int elseCount=1;
    
    code+=generateHTMLFormBody(ifQuestions,"ifStats<x@ref>");
    
    for(elseBranch <- elseifBranch){
        code+=generateHTMLCondBody(elseBranch,"elseIfStats<x@ref>e<elseCount>");
        elseCount+=1;
    }
	   
    code+=generateHTMLFormBody(elseQuestions,"elseStats<x@ref>");
    return code;
}

str generateHTMLCondBody(x:elseif(Expr ifExpression,list[FormBodyItem] elseQuestions),str refID){
    str code="";
	    
    code+=generateHTMLFormBody(elseQuestions,refID);
    return code;
}

str generateHTMLQuestion(simpleQuestion(str questionId,str questionLabel,Type questionType),str refID){
    return questionType==boolean()
    	   ? generateHTMLBooleanInput(questionLabel,questionId,refID) 
    	   : generateHTMLTextInput(questionLabel,questionId,refID);
}
	
str generateHTMLQuestion(computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),str refID){
    return generateHTMLTextInputComputed(questionLabel,questionId,refID);
}

str generateHTMLTextInput(str label,str varName,str id)=
    "<label> : \<INPUT type=\"text\" name=\"<varName>\" id=\"<varName>\" \> \<br\>\n";
		   
str generateHTMLBooleanInput(str label,str varName,str id)=
    "<label> : True\<INPUT type=\"radio\" name=\"<varName>\" id=\"<id>\" value=\"true\"\> 
	           False\<INPUT type=\"radio\" name=\"<varName>\" id=\"<id>\" value=\"false\"\>\<br\>\n";
	
str generateHTMLTextInputComputed(str label,str varName,str id)=
    "<label> : \<INPUT type=\"text\" name=\"<varName>\" id=\"<varName>\" 
    			value=\"dwdw\" readonly=\"readonly\" \> \<br\>\n";	