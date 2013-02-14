module lang::ql::compiler::CompileForm2

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::JavaScriptFunctions;
import IO;

	public str compileForm(form(ident,formBody)){
			   return
			   "\<form name=\"<ident>\" method=\"POST\" \>
			   ' <compileFormBody(formBody)>
			   '\<form/\>";
	}
	
	str compileFormBody(list[FormBodyItem] formItems){
		     str code="";
		      
		     for(x <-formItems){
		     	   if(question(Question itemQuestion) := x){
			     	   	    code+=compileQuestion(itemQuestion);
				     	   }
		     	   else if(conditionalStatement(ConditionalStatement itemCondStatement):=x){
		     	        code+=compileConditional(itemCondStatement);
		     	   }
		     }
		     return code;
	}

	
		str compileQuestion(simpleQuestion(str questionId,str questionLabel,Type questionType)){
	   return "simple <questionLabel>\n";
	}
	
			str compileQuestion(computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation) ){
	   return "computed <questionLabel>\n";
	}
	
	str compileConditional(ifCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[FormBodyItem] elseQuestions)){
	    str code="";
	    //expression
	    
	    code+=compileFormBody(ifQuestions);
	    code+=compileFormBody(elseQuestions);
	    return code;
	}
	
	str compileConditional(simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions)){
	    str code="";
	 
	    //expression
	    print("<seq>\n");
	    code+=compileFormBody(ifQuestions);
	    return code;
	}
	
		str compileConditional(ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestions,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestions)){
	    str code="";
	
	    code+=compileFormBody(ifQuestions);
	    for(x<- elseifBranch){
	        code+=compileConditional(x);
	    }
	   
	    code+=compileFormBody(elseQuestions);
	    return code;
	}
	
			str compileConditional(elseif(Expr ifExpression,list[FormBodyItem] elseQuestions)){
	    str code="";
	 
	    code+=compileFormBody(elseQuestions);
	    return code;
	}
	
	str generateTextInput(str label,str varName,str id)=
		   "<label> : \<INPUT type=\"text\" name=\"<varName>\" id=\"<id>\" \>";
		   
		str generateBooleanInput(str label,str varName,str id)=
		   "<label> : True\<INPUT type=\"radio\" name=\"<varName>\" id=\"<id>\" value=\"true\"\> 
		              False\<INPUT type=\"radio\" name=\"<varName>\" id=\"<id>\" value=\"false\"\>";
		

 
	