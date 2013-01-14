module lang::ql::ast::TypeCheck

import lang::ql::ast::AST;

import Prelude;
import Message;

alias TypeEnv = tuple[map[str, Type] definedVars, set[str] labels, set[Message] errors];

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

TypeEnv addError(TypeEnv env, loc l, str msg) = env[errors = env.errors + error(msg, l)];
TypeEnv addWarning(TypeEnv env, loc l, str msg) = env[errors = env.errors + warning(msg, l)];

public set[Message] checkForm(form(_, list[Statement] statements)) {                                                
  	TypeEnv env = <(), {}, {}>;
  	
	for (s <- statements) {
		env = checkStatement(s, env);
	}
	
	return env.errors;
}

public TypeEnv checkStatement(Statement statement, TypeEnv env) {                                                
	if (ifThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart) := statement) {
		env = checkExpr(condition, {boolType()}, env);
	}
	else if (ifThen(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs) := statement) {
		env = checkExpr(condition, {boolType()}, env);
	}
	
	return env;
}

TypeEnv checkExpr(Expr e, set[Type] req, TypeEnv env) {
	Type resultType = resultTypes[getName(e)];
	
	if (resultType notin req) {
		env = addError(env, e@location, "Required <req>, got <resultType>");
	}
	else if (e has val) {
		set[Type] reqTypes = requiredTypes[getName(e)];
		env = checkExpr(e.val, reqTypes, env);
	}
	else if ((e has lhs) && (e has rhs)) {
		set[Type] reqTypes = requiredTypes[getName(e)];
		env = checkExpr(e.lhs, reqTypes, env);		
		
		if (ident(name) := e.lhs) {
			if (name in env.definedVars) {
				set[Type] reqForRhs = {env.definedVars[name]};
				env = checkExpr(e.rhs, reqForRhs, env);
			}
		}
		else {
			set[Type] reqForRhs = {resultTypes[getName(e.lhs)]};
			env = checkExpr(e.rhs, reqForRhs, env);
		}	
	}
	
	return env;
}

TypeEnv checkExpr(Expr e:ident(str name), set[Type] req, TypeEnv env) {                              
	if (name notin env.definedVars) {
   		env = addError(env, e@location, "Undefined variable \"<name>\"");
	}
	else {
	  	Type tp = env.definedVars[name];
	  	if (req != tp) {
	  		env = addError(env, e@location, "Required <req>, got <tp>");
		}
	}
	
	return env;
}
