module lang::ql::compiler::CompileForm2

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::JavaScriptFunctions;
import IO;
import Node;
import util::ValueUI;
import lang::ql::compiler::GenerateHTMLForm;
import lang::ql::compiler::GenerateJavaScript;

anno str ConditionalStatement@ref;
anno str ElseIf@ref;
anno str FormBodyItem@ref;


public str compileForm(f:form(ident,formBody)){
	formRefrnced=setConditionalReference(formBody);
	print(generateJavaScipt(formRefrnced));
	print("\n\n");
	return generateHTMLForm(ident,formRefrnced);	   
	
}
	
//Sets a reference variable to conditional statements to refer to them
list[FormBodyItem] setConditionalReference(list[FormBodyItem] f){
	int reference=0;
		
	return visit(f){
		case ConditionalStatement cs=> {
			reference+=1; 
			cs[@ref="<reference>"];
		}
		case ElseIf elsecs => {
			reference+=1;  
			elsecs[@ref="<reference>"];
		}
	};

}
	
str compileFormBody(list[FormBodyItem] formItems,str refID){
    str code="";
	
	code+="\<div id=\"<refID>\"\>\n";
    
    for(x <-formItems){
   	   if(question(Question itemQuestion) := x){
   	   	    code+=compileQuestion(itemQuestion,refID);
   	   }
   	   else if(conditionalStatement(ConditionalStatement itemCondStatement):=x){
	   	        code+=compileConditional(itemCondStatement);
     	   }
    	}
    	
     code+="\</div\>\n";
     return code;
}

	

str compileConditional(x:ifCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[FormBodyItem] elseQuestions)){
    str code="";
    //expression
	    
    code+=compileFormBody(ifQuestions,"ifStats<x@ref>");
    code+=compileFormBody(elseQuestions,"elseStats<x@ref>");
    return code;
}
	
str compileConditional(x:simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions)){
    str code="";
	 
    //expression
    code+=compileFormBody(ifQuestions,"ifStats<x@ref>");
    return code;
}
	
str compileConditional(x:ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestions)){
    str code="";
    int elseCount=1;
    code+=compileFormBody(ifQuestions,"ifStats<x@ref>");
    for(elseBranch <- elseifBranch){
        code+=compileConditional(elseBranch,"elseIfStats<x@ref>e<elseCount>");
        elseCount+=1;
    }
	   
    code+=compileFormBody(elseQuestions,"elseStats<x@ref>");
    return code;
}
	
str compileConditional(x:elseif(Expr ifExpression,list[FormBodyItem] elseQuestions),str refID){
    str code="";
	    
    code+=compileFormBody(elseQuestions,refID);
    return code;
}
	
str compileQuestion(simpleQuestion(str questionId,str questionLabel,Type questionType),str refID){
    return questionType==boolean()?generateBooleanInput(questionLabel,questionId,refID):generateTextInput(questionLabel,questionId,refID);
}
	
str compileQuestion(computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),str refID){
    return generateTextInputComputed(questionLabel,questionId,refID);
}
	
	
str generateTextInput(str label,str varName,str id)=
    "<label> : \<INPUT type=\"text\" name=\"<varName>\" id=\"<id>\" \> \<br\>\n";
		   
str generateBooleanInput(str label,str varName,str id)=
    "<label> : True\<INPUT type=\"radio\" name=\"<varName>\" id=\"<id>\" value=\"true\"\> 
	           False\<INPUT type=\"radio\" name=\"<varName>\" id=\"<id>\" value=\"false\"\>\<br\>\n";
	
str generateTextInputComputed(str label,str varName,str id)=
    "<label> : \<INPUT type=\"text\" name=\"<varName>\" id=\"<id>\" 
    			value=\"dwdw\" readonly=\"readonly\" \> \<br\>\n";	

 
	