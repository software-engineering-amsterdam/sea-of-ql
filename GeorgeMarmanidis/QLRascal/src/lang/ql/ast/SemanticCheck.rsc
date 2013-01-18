module lang::ql::ast::SemanticCheck

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import IO;

alias TENV = tuple[ rel[str,str, Type] symbols, list[tuple[loc l, str msg]] errors];//maybe needs list instead of rel
TENV addSymbol(TENV env, str ident, str label,Type idType) = env[symbols = env.symbols + <ident, label,idType>];
TENV addError(TENV env, loc l, str msg) = env[errors = env.errors + <l, msg>];
//
public rel[str, str ,Type] checkForm(loc l) = checkForm(load(l)).symbols;
public list[tuple[loc l, str msg]] checkForm(str src) = checkForm(load(src)).errors;

public TENV checkForm(Form P){                                                
  if(form(str ident,list[FormBodyItem] formBody) := P){
  	 TENV env=<{},[]>;
  	 //find indentifiers
  	 env=getIdentDeclarations(formBody,env);
   	 //and then check FormBody
     //return checkFormBody(formBody,env);
     return env;
  } else
    throw "Syntax error.";
}

TENV getIdentDeclarations(list[FormBodyItem] formBodyItem,TENV env){
	
	
	for(item<-formBodyItem){
		env=getIdentDeclarations(item,env);
	}
	
	return env;	
}

TENV getIdentDeclarations(conditionalStatement(ConditionalStatement itemCondStatement),TENV env){
	env=getIdentDeclarations(itemCondStatement,env);	
	return env;
}

TENV getIdentDeclarations(ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestion),TENV env){
	env=getIdentDeclarations(ifQuestion,env);
	env=getIdentDeclarations(elseQuestion,env);
	env=getIdentDeclarations(elseifBranch,env);
	return env;
}

TENV getIdentDeclarations(list[ElseIf] elseIfStatements,TENV env){
	for(statement<-elseIfStatements){
		if(elseif(Expr ifExpression,list[FormBodyItem] elseQuestion):= statement) env=getIdentDeclarations(elseQuestion,env);
	}
	return env;
}

TENV getIdentDeclarations(simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion),TENV env){
	env=getIdentDeclarations(ifQuestion,env);
	return env;
}

TENV getIdentDeclarations(ifCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[FormBodyItem] elseQuestion),TENV env){
	env=getIdentDeclarations(ifQuestion,env);
	env=getIdentDeclarations(elseQuestion,env);
	return env;
}

TENV getIdentDeclarations(list[Question] questionItem,TENV env){
	for(question<-questionItem){
		env=getIdentDeclarations(question,env);
	}
	return env;
}

TENV getIdentDeclarations(simpleQuestion(str questionId,str questionLabel,Type questionType),TENV env){
	env=addSymbol(env,questionId,questionLabel,questionType);
	print("\nadded simple\n");
	return env;
}

TENV getIdentDeclarations(computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),TENV env){
	env=addSymbol(env,questionId,questionLabel,questionType);
	print("\nadded computed\n");
	return env;
}

TENV getIdentDeclarations(question(Question questionItem),TENV env){
	env=getIdentDeclarations(questionItem,env);
	return env;
}

TENV checkFormBody(list[FormBodyItem] formBodyItem,TENV env){
	
}