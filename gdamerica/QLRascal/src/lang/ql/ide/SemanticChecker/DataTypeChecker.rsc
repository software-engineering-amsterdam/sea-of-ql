/**
 * This module contains the DataType checker (hooked up to the IDE)  
 * @author  Gerson Delgado
 * @version 1.0, 3/02/2013
 */
 
module lang::ql::ide::SemanticChecker::DataTypeChecker

import lang::ql::ast::AST;
import lang::ql::ide::SemanticChecker::Environment;

/**
* Check function for duplicate labels
* This function add warnings to the env in case of duplicate labels  
*/
public ENV checkDuplicateLabels(ENV env){
	for(var1<-env.elements){
		for(var2<-env.elements){
			if(var1.label == var2.label)
				if(var1.id != var2.id) 
					env = addWarning(env, var1.varLoc, required("Duplicate label <var1.Label>"));
		}
	}
	return env;
}


/**
* check function to check a list of Elements 
*/  
public ENV checkListElements(list[Element] elem, ENV env){
	top-down visit(elem){
		case Elem: _(_) : env = checkElement(elem, env);
	}
	return env;	
}

/**
* check function to check a list of ElseIfs 
*/  
private ENV checkElseIfs(list[ElseIf] elseIfs, ENV env){
	for(elseIf<-elseIfs){
		if(elseifCondition(Expr expr, list[Element] elseElem):= elseif){
			env0 = checkExpr(expr, boolean(), env);
			env1 = checkListElements(elseElem, env0);
		}	
	}
	return(env1);
}

/**
* Check whether an identifier has been defined and, if so, whether it is defined with the expected type
*/
private ENV checkExp(exp:ident(str id), DataType req, ENV env) {                              
 	if(isEmpty(env.elements[id]))
     	return addError(env, exp@location, required("Undeclared variable <id>"));
  	tpid = env.elements[id];
  	return req == tpid 
  	? env 
  	: addError(env, exp@location, required("Unexpected DataType", req, tpid));
}
	
/**
* Check functions for default DataTypes
*/
private ENV checkExpr(exp:\int(int i), DataType req, ENV env)
	= req == integer() 
	? env 
	: addError(env, exp@location, required("Required", req, integer()));

private ENV checkExpr(exp:"string"(str s), DataType req, ENV env)
	= req == string() 
	? env 
	: addError(env, exp@location, required("Required", req, string()));

private ENV checkExpr(expr:"boolean"(bool b), DataType req, ENV env)
	= req == boolean() 
	? env 
	: addError(env, expr@location, required("Required", req, boolean()));

/**
* Check functions for comparision operators 
*/
private ENV checkExpr(exp:lt(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));

private ENV checkExpr(exp:leq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

private ENV checkExpr(exp:gt(Expr lhs, Expr rhs), DataType req, ENV env) 
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

private ENV checkExpr(exp:geq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, integer(), checkExpr(rhs, integer(), env)) 
	: addError(env, exp@location, requires("Comparision operand",integer()));	

private ENV checkExpr(exp:eq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() || req == string() || req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("comparision on unequal operands types not supported", req));

private ENV checkExpr(exp:neq(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() || req == string() || req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("comparision on unequal operands types not supported", req));

/**
* Check functions for boolean operators
*/	
private ENV checkExpr(exp:not(Expr n), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(n, req, env) 
	: addError(env, exp@location, required("NOT operator", boolean(), req));

private ENV checkExpr(exp:and(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("AND operator", boolean(), req));

private ENV checkExpr(exp:or(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == boolean() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("OR operator", boolean(), req));	
			
/**
* Check functions for arithmetic operations
*/
private ENV checkExpr(exp:mul(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Multiplication operation", integer(), req));
	
private ENV checkExpr(exp:div(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Division operation", integer(), req));	
	
private ENV checkExpr(exp:add(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() || req == string() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Addition on unequal operands types not supported,", req));

private ENV checkExpr(exp:sub(Expr lhs, Expr rhs), DataType req, ENV env)
	= req == integer() 
	? checkExpr(lhs, req, checkExpr(rhs, req, env)) 
	: addError(env, exp@location, required("Substraction operation", integer(), req));

private ENV checkExpr(exp:pos(Expr p), DataType req, ENV env)
	= req == integer() 
	? checkExpr(p, req, env) 
	: addError(env, exp@location, required("Positive operator", integer(), req));
	
private ENV checkExpr(exp:neg(ng), DataType req, ENV env)
	= req == integer() 
	? checkExpr(ng, req, env) 
	: addError(env, exp@location, required("Negative operator", integer(), req));

	
/**
* Check functions for Forms, Forms Elements and Conditions
*/
private ENV checkQuestion(singleQuestion(str id, str Label, DataType qDataType), ENV env) {
	return addElement(env, id, Label, qDataType);
}

private ENV checkQuestion(singleQuestion(str id, str Label, DataType qDataType), ENV env) = env;

private ENV checkQuestion(computableQuestion(str id, str Label, DataType qDataType, Expr qExpr), ENV env) = checkExpr(qExpr, qDataType, env);

private ENV checkElement(question(Question qstn), ENV env) = checkQuestion(qstn, env);
	
private ENV checkElement(condition(Condition cond), ENV env) = checkElement(cond, env);
	
private ENV checkElement(singleIfCondition(Expr expr, list[Element] ifElem), ENV env){
	env0 = checkExpr(expr, boolean(), env);
	env1 = checkListElements(ifElem, env0);
	return(env1);
}

private ENV checkElement(elseifCondition(Expr expr, list[Element] ifElem, list[ElseIf] elseIfs, list[Element] elseElem),ENV env){
	env0 = checkExpr(expr, boolean(), env);
	env1 = checkListElements(ifElem, env0);
	env2 = checkElseIfs(elseIfs, env1);
	env3 = checkListElements(elseElem, env2);
	return(env3);
}
