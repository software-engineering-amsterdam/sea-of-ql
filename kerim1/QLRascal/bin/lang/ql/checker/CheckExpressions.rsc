module lang::ql::checker::CheckExpressions

import Prelude;
import Message;

import lang::ql::generator::Pretty;

import lang::ql::ast::AST;
import lang::ql::ast::TypeEnvironment;
import lang::ql::ast::VariableDependencies;

map[str, set[Type]] requiredTypes = (
 	"pos": 		{intType()},
  	"neg": 		{intType()},
 	"not": 		{boolType()},
 	"mul": 		{intType()},
 	"div": 		{intType()},
 	"add": 		{intType()},
  	"sub": 		{intType()},
 	"lt": 		{intType(), stringType()},
 	"leq": 		{intType(), stringType()},	
  	"gt": 		{intType(), stringType()},
  	"geq": 		{intType(), stringType()},
 	"eq": 		{boolType(), intType(), stringType()},
  	"neq": 		{boolType(), intType(), stringType()},
  	"and": 		{boolType()},
  	"or": 		{boolType()}
);

map[str, Type] resultTypes = (
	"int": 		intType(),
	"bool": 	boolType(),
 	"string": 	stringType(),
 	"pos": 		intType(),
  	"neg": 		intType(),
 	"not": 		boolType(),
 	"mul": 		intType(),
 	"div": 		intType(),
 	"add": 		intType(),
  	"sub": 		intType(),
 	"lt": 		boolType(),
 	"leq": 		boolType(),
  	"gt": 		boolType(),
  	"geq": 		boolType(),
 	"eq": 		boolType(),
  	"neq": 		boolType(),
  	"and": 		boolType(),
  	"or": 		boolType()
);

public str getReadableTypes(set[Type] types) = 
	intercalate(" or ", [pretty(tp) | tp <- types]);

public set[Message] checkExpressions(Form form) {
	TypeEnv typeEnv = getTypeEnvironment(form);
	VarDependencies varDependencies = getVarDependencies(form);
	set[Message] errors = {};
	
	visit (form) {
		case ifThenElse(Expr e, _, _, _):
			errors = checkExpr(e, {boolType()}, typeEnv, varDependencies, errors);
		case ifThen(Expr e, _, _):
  			errors = checkExpr(e, {boolType()}, typeEnv, varDependencies, errors);
  		case elseIf(Expr e, _):
			errors = checkExpr(e, {boolType()}, typeEnv, varDependencies, errors);
		case computed(_, _, Type tp, Expr e):
			errors = checkExpr(e, {tp}, typeEnv, varDependencies, errors);
	}
	
	return errors;
}

set[Message] checkExpr(Expr e, set[Type] req, TypeEnv typeEnv, VarDependencies varDependencies, set[Message] errors) {
	Type resultType = resultTypes[getName(e)];
	
	if (resultType notin req) {
		errors += error("Required <getReadableTypes(req)>, got <pretty(resultType)>", e@location);
	}
	else if (e has val) {
		errors = checkUnaryExpr(e, typeEnv, varDependencies, errors);
	}
	else if ((e has lhs) && (e has rhs)) {
		errors = checkBinaryExpr(e, typeEnv, varDependencies, errors);
	}
	
	return errors;
}

set[Message] checkUnaryExpr(Expr e, TypeEnv typeEnv, VarDependencies varDependencies, set[Message] errors) {
	set[Type] reqTypes = requiredTypes[getName(e)];
	return checkExpr(e.val, reqTypes, typeEnv, varDependencies, errors);
}

set[Message] checkBinaryExpr(Expr e, TypeEnv typeEnv, VarDependencies varDependencies, set[Message] errors) {
	set[Type] reqTypes = requiredTypes[getName(e)];
	errors = checkExpr(e.lhs, reqTypes, typeEnv, varDependencies, errors);		
	
	set[Type] reqForRhs = {};
	if (ident(name) := e.lhs) {
		if (isInTypeEnvironment(name, typeEnv)) {
			reqForRhs = {getTypeForIdentifier(name, typeEnv)};
		}
	}
	else {
		reqForRhs = {resultTypes[getName(e.lhs)]};
	}
	
	return checkExpr(e.rhs, reqForRhs, typeEnv, varDependencies, errors);
}

/* Type checking on identifiers in expressions, 
 * checking for undefined variables used in expressions 
 * and checking for cyclic dependencies
 */
set[Message] checkExpr(Expr e:ident(str name), set[Type] req, TypeEnv typeEnv, VarDependencies varDependencies, set[Message] errors) {                              
	if (!isInTypeEnvironment(name, typeEnv)) {
   		errors += error("Undefined variable \"<name>\"", e@location);
	}
	else {
	  	Type tp = getTypeForIdentifier(name, typeEnv);
	  	if (tp notin req) {
	  		errors += error("Required <getReadableTypes(req)>, got <pretty(tp)>", e@location);
		}
		
		for (str identifier <- varDependencies[name]) {
			if ((identifier in varDependencies) && (name in varDependencies[identifier])) {
				errors += error("Cyclic dependency for <name> and <identifier>", e@location);
			}	
		}		
	}
	
	return errors;
}
