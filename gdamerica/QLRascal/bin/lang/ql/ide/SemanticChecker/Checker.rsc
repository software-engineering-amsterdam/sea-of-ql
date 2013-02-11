/**
 * This module contains the DataType checker (hooked up to the IDE)  
 * @author  Gerson Delgado
 * @version 1.0, 3/02/2013
 */
 
module lang::ql::ide::SemanticChecker::Checker

import lang::ql::ast::AST;
import lang::ql::ide::SemanticChecker::Environment;
import Set;
import lang::ql::util::Implode;


/**
* Check whether an identifier has been defined and, if so, whether it is defined with the expected type
*/
ENV checkExp(exp:ident(str id), DataType req, ENV env) {                              
 	if(isEmpty(env.variables[id]))
     	return addError(env, exp@location, "Undeclared variable <id>");
  	tpid = env.variables[id];
  	return req == tpid 
  	? env 
  	: addError(env, exp@location, required("Unexpected DataType", req, tpid));
}	
/**
* Hulp functions to check a list of Elements and ElseIfs
*/  
ENV checkListElements(list[Element] elements, ENV env){
	for(elem<-elements){
		env = checkElement(elem, env);
	}	
	return env;	
}

ENV checkElseIfs(list[ElseIf] elseIfs, ENV env){
	for(elseIf<-elseIfs){
		if(elseifCondition(Expr expr, list[Element] elseElem):= elseif){
			env0 = checkExpr(expr, boolean(), env);
			env1 = checkListElements(elseElem, env0);
		}	
	}
	return(env1);
}
	
/**
* Check functions for default DataTypes
*/
ENV checkExpr(exp:\int(int i), DataType req, ENV env)
	= req == integer() 
	? env 
	: addError(env, exp@location, required("Required", req, integer()));

ENV checkExpr(exp:"string"(str s), DataType req, ENV env)
	= req == string() 
	? env 
	: addError(env, exp@location, required("Required", req, string()));

ENV checkExpr(expr:"boolean"(bool b), DataType req, ENV env)
	= req == boolean() 
	? env 
	: addError(env, expr@location, required("Required", req, boolean()));

/**
* Check functions for comparision operators 
*/
ENV checkExpr(exp:lt(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));

ENV checkExpr(exp:leq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

ENV checkExpr(exp:gt(Expr lhs, Expr rhs), DataType req, ENV env) 
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

ENV checkExpr(exp:geq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

ENV checkExpr(exp:eq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() || req == string() || req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("comparision on unequal operands types not supported", req));

ENV checkExpr(exp:neq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() || req == string() || req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("comparision on unequal operands types not supported", req));

/**
* Check functions for boolean operators
*/	
ENV checkExpr(exp:not(Expr n), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(n, req, env) 
	: addError(env, exp@location, required("NOT operator", boolean(), req));

ENV checkExpr(exp:and(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("AND operator", boolean(), req));

ENV checkExpr(exp:or(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("OR operator", boolean(), req));	
			
/**
* Check functions for arithmetic operations
*/
ENV checkExpr(exp:mul(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Multiplication operation", integer(), req));
	
ENV checkExpr(exp:div(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Division operation", integer(), req));	
	
ENV checkExpr(exp:add(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() || req == string() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Addition on unequal operands types not supported,", req));

ENV checkExpr(exp:sub(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Substraction operation", integer(), req));

ENV checkExpr(exp:pos(Expr p), DataType req, ENV env)
	= req == integer() 
	? checkExpr(p, req, env) 
	: addError(env, exp@location, required("Positive operator", integer(), req));
	
ENV checkExpr(exp:neg(ng), DataType req, ENV env)
	= req == integer() 
	? checkExpr(ng, req, env) 
	: addError(env, exp@location, required("Negative operator", integer(), req));
	
/**
* Check functions for Forms, Forms Elements and Conditions
*/

ENV checkQuestion(singleQuestion(str id, str descr, DataType qDataType), ENV env) {
	return addElement(env, id, descr, qDataType);
}

ENV checkElement(question(Question qstn), ENV env) = checkQuestion(qstn, env);
	
ENV checkElement(condition(Condition cond), ENV env) = checkElement(cond, env);
	
ENV checkElement(singleIfCondition(Expr expr, list[Element] ifElem), ENV env){
	env0 = checkExpr(expr, boolean(), env);
	env1 = checkListElements(ifElem, env0);
	return(env1);
}

ENV checkElement(elseifCondition(Expr expr, list[Element] ifElem, list[ElseIf] elseIfs, list[Element] elseElem),ENV env){
	env0 = checkExpr(expr, boolean(), env);
	env1 = checkListElements(ifElem, env0);
	env2 = checkElseIfs(elseIfs, env1);
	env3 = checkListElements(elseElem, env2);
	return(env3);
}
/**
* Check function QL forms
*/
public ENV checkForm(Form f){                                                
 	if(form(str id, list[Element] fElem ) := f){	 
		ENV env = <{},[]>; 
     	env0 = checkListElements(fElem, env);
	 	return env0;
  } else
     	throw "Syntax Error";
}
/**
* Function defines how to check the source code of a given Form 
*/
                                                                           
public list[tuple[loc l, str msg]] checkForm(str txt) = checkForm(load(txt)).errors;
