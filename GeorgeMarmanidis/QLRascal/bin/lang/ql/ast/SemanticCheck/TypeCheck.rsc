@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::SemanticCheck::TypeCheck

import lang::ql::ast::SemanticCheck::utilities;
import lang::ql::ast::AST;

public TENV checkFormBody(list[FormBodyItem] formBodyItem,TENV env){
	for(item<-formBodyItem){
		env=checkFormBodyItem(item,env);
	}	
	return env;	
}

TENV checkFormBodyItem(question(Question itemQuestion),TENV env){
	env=checkQuestion(itemQuestion,env);
	return(env);
}

TENV checkFormBodyItem(conditionalStatement(ConditionalStatement itemCondStatement),TENV env){
	env=checkFormBodyItem(itemCondStatement,env);
	return(env);
}

TENV checkFormBodyItem(ifCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[FormBodyItem] elseQuestion),TENV env){
	env=checkExpression(ifCondition,boolean(),env);
	env=checkFormBody(ifQuestion,env);
	env=checkFormBody(elseQuestion,env);
	return(env);
}

TENV checkFormBodyItem(simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion),TENV env){
	env=checkExpression(ifCondition,boolean(),env);
	env=checkFormBody(ifQuestion,env);
	return(env);
}

TENV checkFormBodyItem(ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestion),TENV env){
	env=checkExpression(ifCondition,boolean(),env);
	env=checkFormBody(ifQuestion,env);
	env=checkFormBodyItem(elseifBranch,env);
	env=checkFormBody(elseQuestion,env);
	return(env);
}

TENV checkFormBodyItem(list[ElseIf] elseIfStatements,TENV env){
	for(statement<-elseIfStatements){
		if(elseif(Expr ifExpression,list[FormBodyItem] elseQuestion):= statement){
			env=checkExpression(ifExpression,boolean(),env);
			env=checkFormBody(elseQuestion,env);
		}	
	}
	return(env);
}

TENV checkQuestion(simpleQuestion(str questionId,str questionLabel,Type questionType),TENV env){
	return env;
}

TENV checkQuestion(computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),TENV env){
	env=checkExpression(questionComputation,questionType,env);
	return(env);
}

TENV checkExpression(exp:\int(int ivalue),Type req,TENV env){
	return req==integer() ? env : addError(env, exp@location, "Required <req> but got integer");
}

TENV checkExpression(exp:"string"(str strValue),Type req,TENV env){
	return req==string() ? env : addError(env, exp@location, "Required <req> but got string");
}

TENV checkExpression(expr:"boolean"(str bValue),Type req,TENV env){
	return req==boolean() ? env : addError(env, expr@location, "Required <req> but got boolean");
}

TENV checkExpression(exp:ident(str name),Type req,TENV env){
	bool declaredIdent=false; // 
	Type idType=integer();
	
	for(tup<-env.symbols){
		if(tup.variableName==name){
			declaredIdent=true;
			idType=tup.variableType;
		}
	}
	
	if(!declaredIdent) return addError(env,exp@location,"Undeclared identifier <name>");
	
	return req==idType ? env : addError(env,exp@location,"Required <req> but got <idType>");
}

TENV checkExpression(exp:eq(Expr eqLeft, Expr eqRight),Type req,TENV env){
	return req==boolean()||req==string()||req==integer() ? checkExpression(eqLeft,req,checkExpression(eqRight,req,env)) : addError(env, exp@location, "Required <req> statement in condition");
}

TENV checkExpression(exp:neq(Expr eqLeft, Expr eqRight),Type req,TENV env){
	return req==boolean() ? checkExpression(eqLeft,integer(),checkExpression(eqRight,integer(),env)) : addError(env, exp@location, "Required <req> statement in condition");
}

TENV checkExpression(exp:lt(Expr ltLeft, Expr ltRight),Type req,TENV env){
	return req==boolean() ? checkExpression(ltLeft,integer(),checkExpression(ltRight,integer(),env)) : addError(env, exp@location, "Required integer in condition");
}

TENV checkExpression(exp:leq(Expr ltLeft, Expr ltRight),Type req,TENV env){
	return req==boolean() ? checkExpression(ltLeft,integer(),checkExpression(ltRight,integer(),env)) : addError(env, exp@location, "Required integer in condition");
}

TENV checkExpression(exp:gt(Expr ltLeft, Expr ltRight),Type req,TENV env){
	return req==boolean() ? checkExpression(ltLeft,integer(),checkExpression(ltRight,integer(),env)) : addError(env, exp@location, "Required integer in condition");
}

TENV checkExpression(exp:geq(Expr ltLeft, Expr ltRight),Type req,TENV env){
	return req==boolean() ? checkExpression(ltLeft,integer(),checkExpression(ltRight,integer(),env)) : addError(env, exp@location, "Required integer in condition");
}

TENV checkExpression(exp:and(Expr andLeft, Expr andRight),Type req,TENV env){
	return req==boolean() ? checkExpression(andLeft,req,checkExpression(andRight,req,env)) : addError(env, exp@location, "Required boolean statement in condition but got <req>");
}

TENV checkExpression(exp:or(Expr orLeft, Expr orRight),Type req,TENV env){
	return req==boolean() ? checkExpression(orLeft,req,checkExpression(orRight,req,env)) : addError(env, exp@location, "Required boolean statement in condition but got <req>");
}

TENV checkExpression(exp:not(Expr notValue),Type req,TENV env){
	return req==boolean() ? checkExpression(notValue,req,env) : addError(env, exp@location, "Required boolean statement in condition but got <req>");
}

TENV checkExpression(exp:neg(Expr negValue),Type req,TENV env){
	return req==integer() ? checkExpression(negValue,req,env) : addError(env, exp@location,   "Required integer in arethmetic operations but got <req>.");
}

TENV checkExpression(exp:pos(Expr posValue),Type req,TENV env){
	return req==integer() ? checkExpression(posValue,req,env) : addError(env, exp@location,  "Required integer in arethmetic operations but got <req>.");
}

TENV checkExpression(exp:add(Expr addLeft, Expr addRight),Type req,TENV env){
	return req==integer() || req== string() ? checkExpression(addLeft,req,checkExpression(addRight,req,env)) : addError(env, exp@location, "Required <req>. Both should be the same type .");
}

TENV checkExpression(exp:mul(Expr multLeft, Expr multRight),Type req,TENV env){
	return req==integer() ? checkExpression(multLeft,req,checkExpression(multRight,req,env)) : addError(env, exp@location,  "Required integer in arethmetic operations but got <req>.");
}

TENV checkExpression(exp:div(Expr divLeft, Expr divRight),Type req,TENV env){
	return req==integer() ? checkExpression(divLeft,req,checkExpression(divRight,req,env)) : addError(env, exp@location,  "Required integer in arethmetic operations but got <req>.");
}

TENV checkExpression(exp:sub(Expr subLeft, Expr subRight),Type req,TENV env){
	return req==integer() ? checkExpression(subLeft,req,checkExpression(subRight,req,env)) : addError(env, exp@location,  "Required integer in arethmetic operations but got <req>.");
}