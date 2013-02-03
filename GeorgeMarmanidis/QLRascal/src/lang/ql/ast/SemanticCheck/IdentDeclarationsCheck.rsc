@contributor{George Marmanidis -geo.marmani@gmail.com}

module lang::ql::ast::semanticcheck::IdentDeclarationsCheck

import lang::ql::ast::semanticcheck::TypeEnvUtils;
import lang::ql::ast::AST;

public TENV getIdentDeclarations(list[FormBodyItem] formBodyItems,TENV env){
	visit(formBodyItems){
		case q:simpleQuestion(_,_,_) : env=getIdentDeclarations(q,env);
		case q:computedQuestion(_,_,_,_) : env=getIdentDeclarations(q,env);
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
			
			if(questionType!=x.variableType){
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
			
			if(questionType!=x.variableType){
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
