module lang::ql::ast::SemanticCheck::IdentDeclarations

import lang::ql::ast::SemanticCheck::utilities;
import lang::ql::ast::AST;

import IO;

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
	
	env=addSymbol(env,questionId,questionLabel,questionType,false);
	return env;
}

TENV getIdentDeclarations(question:computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),TENV env){
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
	
	
	env=addSymbol(env,questionId,questionLabel,questionType,true);
	return env;
}

TENV getIdentDeclarations(question(Question questionItem),TENV env){
	env=getIdentDeclarations(questionItem,env);
	return env;
}