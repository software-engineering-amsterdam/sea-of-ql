/**
 * This module contains the functions for the DataType checker (hooked up to the IDE)  
 * @author  Gerson Delgado
 * @version 1.0, 3/02/2013
 */
 
module lang::ql::ide::SemanticChecker::DataTypeChecker

import lang::ql::ast::AST;
import lang::ql::ide::SemanticChecker::Environment;
import Set;

public ENV checkListElements(list[Element] elem, ENV env){
	top-down visit(elem){
		case qstn:computableQuestion(_,_,_,_) 
			: env = checkQuestion(qstn, env);
		case qstn:singleQuestion(_,_,_) 
			: env = checkQuestion(qstn, env);
		case cond:singleIfCondition(_,_) 
			: env = checkElement(cond, env);
		case cond:ifElseCondition(_,_,_) 
			: env = checkElement(cond, env);
	}
	return env;	
}
 
private DataType getExprDataType(Expr expr, ENV env){
	top-down-break visit (expr){
		case ident(str name)
			: return getIdentDataType(name, env);
		case \int(_) 
			: return integer();
		case boolean(_)
			: return string();
		case string(_)
			: return boolean();
		case money(_)
			: return money();
		case date(_)
			: return date();
		case decimal(_)
			: return decimal();
	}
}
 
private DataType getIdentDataType(str id, ENV env){
	varDataType = boolean();
	for(var<-env.elements){
		if(id == var.id) 
			varDataType = var.elemDataType;
	}
	return varDataType;
}

private ENV checkExpr(exp:ident(str name), DataType req, ENV env) { 
	bool isDeclared = false;
	varDataType = boolean();
	
	for(var1 <- env.elements){                             
 		if(var1.id == name)
 			isDeclared = true;
 			varDataType = var1.elemDataType;				
	}
	if(!isDeclared)
		return addError(env, exp@location, required("Undeclared variable <name>"));
	else 
		return req == varDataType 
			   ? env 
			   : addError(env, exp@location, required("Unexpected DataType", req, varDataType)); 	
}

private ENV checkExpr(exp:\int(int iValue), DataType req, ENV env)
	= req == integer() 
	? env 
	: addError(env, exp@location, required("Required", req, integer()));

private ENV checkExpr(exp:strCon(str strValue), DataType req, ENV env)
	= req == string() 
	? env 
	: addError(env, exp@location, required("Required", req, string()));

private ENV checkExpr(expr:boolCon(bool bValue), DataType req, ENV env)
	= req == boolean() 
	? env 
	: addError(env, expr@location, required("Required", req, boolean()));

private ENV checkExpr(exp:lt(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhsValue, integer(), checkExpr(rhsValue, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));

private ENV checkExpr(exp:leq(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhsValue, integer(), checkExpr(rhsValue, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

private ENV checkExpr(exp:gt(Expr lhsValue, Expr rhsValue), DataType req, ENV env) 
	= req == boolean() 
	? checkExpr(lhsValue, integer(), checkExpr(rhsValue, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

private ENV checkExpr(exp:geq(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhsValue, integer(), checkExpr(rhsValue, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

private ENV checkExpr(exp:eq(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == boolean() || req == string() || req == integer() 
	? checkExpr(lhsValue, getExprDataType(lhsValue, env), checkExpr(rhsValue, getExprDataType(lhsValue, env), env)) 
	: addError(env, exp@location, required("comparision on unequal operands types not supported", req));

private ENV checkExpr(exp:neq(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == boolean() || req == string() || req == integer() 
	? checkExpr(lhsValue, getExprDataType(lhsValue, env), checkExpr(rhsValue, getExprDataType(lhsValue, env), env))
	: addError(env, exp@location, required("comparision on unequal operands types not supported", req));

private ENV checkExpr(exp:not(Expr notValue), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(notValue, req, env) 
	: addError(env, exp@location, required("NOT operator", boolean(), req));

private ENV checkExpr(exp:and(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhsValue, req, checkExpr(rhsValue, req, env)) 
	: addError(env, exp@location, required("AND operator", boolean(), req));

private ENV checkExpr(exp:or(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhsValue, req, checkExpr(rhsValue, req, env)) 
	: addError(env, exp@location, required("OR operator", boolean(), req));	
			
private ENV checkExpr(exp:mul(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhsValue, req, checkExpr(rhsValue, req, env)) 
	: req == boolean()
	? addError(env, exp@location, required("Multiplication on <req> Datatype not supported"))
	: addError(env, exp@location, required("Multiplication operation", integer(), req));
	
private ENV checkExpr(exp:div(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhsValue, req, checkExpr(rhsValue, req, env))
	: req == boolean()
	? addError(env, exp@location, required("Division on <req> Datatype not supported")) 
	: addError(env, exp@location, required("Division operation", integer(), req));	
	
private ENV checkExpr(exp:add(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == integer() || req == string() 
	? checkExpr(lhsValue, req, checkExpr(rhsValue, req, env)) 
	: req == boolean()
	? addError(env, exp@location, required("Addition on <req> Datatype not supported"))
	: addError(env, exp@location, required("Addition on unequal operands Datatypes not supported,", req));

private ENV checkExpr(exp:sub(Expr lhsValue, Expr rhsValue), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhsValue, req, checkExpr(rhsValue, req, env))
	: req == boolean()
	? addError(env, exp@location, required("Substraction on <req> Datatype not supported")) 
	: addError(env, exp@location, required("Substraction operation", integer(), req));

private ENV checkExpr(exp:pos(Expr posValue), DataType req, ENV env)
	= req == integer() 
	? checkExpr(posValue, req, env) 
	: addError(env, exp@location, required("Positive operator", integer(), req));
	
private ENV checkExpr(exp:neg(negValue), DataType req, ENV env)
	= req == integer() 
	? checkExpr(negValue, req, env) 
	: addError(env, exp@location, required("Negative operator", integer(), req));

private ENV checkQuestion(singleQuestion(str id, str Label, DataType qDataType), ENV env) = env;

private ENV checkQuestion(computableQuestion(str id, str Label, DataType qDataType, Expr qExpr), ENV env) = checkExpr(qExpr, qDataType, env);

private ENV checkElement(question(Question qstn), ENV env) = checkQuestion(qstn, env);
	
private ENV checkElement(condition(Condition cond), ENV env) = checkElement(cond, env);
	
private ENV checkElement(singleIfCondition(Expr expr, list[Element] ifElem), ENV env){	
	env0 = checkExpr(expr, boolean(), env);
	env1 = checkListElements(ifElem, env0);
	return(env1);
}

private ENV checkElement(ifElseCondition(Expr expr, list[Element] ifElem, list[Element] elseElem),ENV env){
	env0 = checkExpr(expr, boolean(), env);
	env1 = checkListElements(ifElem, env0);
	env2 = checkListElements(elseElem, env1);
	return(env2);
}

