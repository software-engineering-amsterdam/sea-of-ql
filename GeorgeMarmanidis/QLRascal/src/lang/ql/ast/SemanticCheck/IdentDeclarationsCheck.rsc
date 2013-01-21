@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::SemanticCheck::IdentDeclarationsCheck

import lang::ql::ast::SemanticCheck::utilities;
import lang::ql::ast::AST;

//Retrieves all the identifiers and keeps type,location,label and if is computed.
public TENV getIdentDeclarations(list[FormBodyItem] formBodyItem,TENV env){
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

TENV getIdentDeclarations(question:simpleQuestion(str questionId,str questionLabel,Type questionType),TENV env){
	
	//we search for duplicating identifiers in this part of the code
	//For every identifier we check the env if it's already existing
	//if it exists with different variable type or in a computedQuestion
	//it throws an error 
	for(x<-env.symbols){
		if(questionId==x.variableName){
			
			if(!(questionType==x.variableType)){
				return env=addError(env,question@location,"Same identifier declared with different type");
			}
			else{
				if(x.isComputed){
					return env=addError(env,question@location,"Question binds the same variable with a computed question");
					}
				}
		}
	}
	
	env=addSymbol(env,questionId,questionLabel,questionType,false,question@location);
	return env;
}

TENV getIdentDeclarations(question:computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),TENV env){
	
	//we search for duplicating identifiers in this part of the code
	//For every identifier we check the env if it's already existing
	//if it exists with different variable type or in a simpleQuestion
	//it throws an error 
	for(x<-env.symbols){
		if(questionId==x.variableName){
			
			if(!(questionType==x.variableType)){
				return env=addError(env,question@location,"Same identifier declared with different type");
			}
			else{
				if(!x.isComputed){
					return env=addError(env,question@location,"Question binds the same variable with an answerable question");
					}
				}
		}
	}
	
	
	env=addSymbol(env,questionId,questionLabel,questionType,true,question@location);
	return env;
}

TENV getIdentDeclarations(question(Question questionItem),TENV env){
	env=getIdentDeclarations(questionItem,env);
	return env;
}