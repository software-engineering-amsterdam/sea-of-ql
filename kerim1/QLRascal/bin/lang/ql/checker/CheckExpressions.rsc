module lang::ql::checker::CheckExpressions

import Prelude;
import Message;

import lang::ql::ast::AST;
import lang::ql::checker::Check;
import lang::ql::generator::Pretty;

// Public aliases do not work
public alias CheckEnv = tuple[
	map[str, Type] questionVars,
	map[str, Type] computedQuestionVars, // We have to build the type environment ourselves to check for duplicates
	map[str, set[str]] varsDependencies,
	rel[Expr expr, Type reqType] expressions, // Store all expressions while visiting tree, to check them later
	set[str] labels, 
	set[Message] errors
];

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

public CheckEnv checkExpr(Expr e, set[Type] req, CheckEnv env) {
	Type resultType = resultTypes[getName(e)];
	
	if (resultType notin req) {
		env = addError(env, e@location, "Required <getReadableTypes(req)>, got <pretty(resultType)>");
	}
	else if (e has val) {
		env = checkUnaryExpr(e, env);
	}
	else if ((e has lhs) && (e has rhs)) {
		env = checkBinaryExpr(e, env);
	}
	
	return env;
}

CheckEnv checkUnaryExpr(Expr e, CheckEnv env) {
	set[Type] reqTypes = requiredTypes[getName(e)];
	return checkExpr(e.val, reqTypes, env);
}

CheckEnv checkBinaryExpr(Expr e, CheckEnv env) {
	set[Type] reqTypes = requiredTypes[getName(e)];
	env = checkExpr(e.lhs, reqTypes, env);		
	
	set[Type] reqForRhs;
	if (ident(name) := e.lhs) {
		if (isVariableDefined(env, name)) {
			reqForRhs = {getTypeOfVariable(env, name)};
		}
	}
	else {
		reqForRhs = {resultTypes[getName(e.lhs)]};
	}
	
	return checkExpr(e.rhs, reqForRhs, env);
}

/* Type checking on identifiers in expressions, 
 * checking for undefined variables used in expressions 
 * and checking for cyclic dependencies
 */
public CheckEnv checkExpr(Expr e:ident(str name), set[Type] req, CheckEnv env) {                              
	if (!isVariableDefined(env, name)) {
   		env = addError(env, e@location, "Undefined variable \"<name>\"");
	}
	else {
	  	Type tp = getTypeOfVariable(env, name);
	  	if (tp notin req) {
	  		env = addError(env, e@location, "Required <getReadableTypes(req)>, got <pretty(tp)>");
		}
		
		for (str identifier <- env.varsDependencies[name]) {
			if ((identifier in env.varsDependencies) && (name in env.varsDependencies[identifier])) {
				env = addError(env, e@location, "Cyclic dependency for <name> and <identifier>");
			}	
		}		
	}
	
	return env;
}
