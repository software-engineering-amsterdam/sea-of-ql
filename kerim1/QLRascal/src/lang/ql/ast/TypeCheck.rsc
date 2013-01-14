module lang::ql::ast::TypeCheck

import lang::ql::ast::AST;

import Prelude;
import Message;

alias TypeEnv = tuple[
	map[str, Type] questionVars,
	map[str, Type] computedQuestionVars, 
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

// Add values to the type environment
TypeEnv addQuestionVar(TypeEnv env, str ident, Type tp) = env[questionVars = env.questionVars + (ident: tp)];
TypeEnv addComputedQuestionVar(TypeEnv env, str ident, Type tp) = env[computedQuestionVars = env.computedQuestionVars + (ident: tp)];
TypeEnv addLabel(TypeEnv env, str label) = env[labels = env.labels + label];
TypeEnv addError(TypeEnv env, loc l, str msg) = env[errors = env.errors + error(msg, l)];
TypeEnv addWarning(TypeEnv env, loc l, str msg) = env[errors = env.errors + warning(msg, l)];

bool isVariableDefined(TypeEnv env, str ident) = (ident in env.questionVars) || (ident in env.computedQuestionVars);
Type getTypeOfVariable(TypeEnv env, str ident) {
	if (ident in env.questionVars) {
		return env.questionVars[ident];
	}
	else if (ident in env.computedQuestionVars) {
		return env.computedQuestionVars[ident];
	}
}

public set[Message] checkForm(form(_, list[Statement] statements)) {                                                
  	TypeEnv env = <(), (), {}, {}>;
  	
	for (s <- statements) {
		env = checkStatement(s, env);
	}
	
	return env.errors;
}

TypeEnv checkStatement(question(Question q), TypeEnv env) = checkQuestion(q, env);

TypeEnv checkStatement(Statement statement, TypeEnv env) {
	env = checkExpr(statement.condition, {boolType()}, env);
	
	for (elseIf(Expr condition, list[Statement] thenPart) <- statement.elseIfs) {
		env = checkExpr(condition, {boolType()}, env);
	}
	
	for (s <- statement.thenPart) {
		env = checkStatement(s, env);
	}
	
	for (elseIf(Expr condition, list[Statement] thenPart) <- statement.elseIfs) {
		for (s <- thenPart) {
			env = checkStatement(s, env);
		}
	}
	
	if (statement has elsePart) {
		for (s <- statement.elsePart) {
			env = checkStatement(s, env);
		}
	}
	
	return env;
}

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable 
 * and provides warnings for duplicate labels.
 */
TypeEnv checkQuestion(q:computed(str identifier, str label, Type tp, Expr expression), TypeEnv env) {
	if (identifier in env.computedQuestionVars) {		
		Type declaredType = env.computedQuestionVars[identifier];
		
		if (declaredType != tp) {
			env = addError(env, q@location, "Question has already been defined before with type <declaredType>");
		}
	}
	else { 
		if (identifier in env.questionVars) {
			env = addError(env, q@location, "There is already a non-computed version of this question");	
		}
		
		env = addComputedQuestionVar(env, identifier, tp);
	}
	
	if (label in env.labels) {
		env = addWarning(env, q@location, "Duplicate label");	
	}
	else {
		env = addLabel(env, label);
	}
	
	env = checkExpr(expression, {tp}, env);
	
	return env;
}

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable 
 * and provides warnings for duplicate labels.
 */
TypeEnv checkQuestion(q:noncomputed(str identifier, str label, Type tp), TypeEnv env) {
	if (identifier in env.questionVars) {	
		Type declaredType = env.questionVars[identifier];
		
		if (declaredType != tp) {
			env = addError(env, q@location, "Question has already been defined before with type <declaredType>");
		}		
	}
	else { 
		if (identifier in env.computedQuestionVars) {
			env = addError(env, q@location, "There is already a computed version of this question");	
		}
		
		env = addQuestionVar(env, identifier, tp);
	}
	
	if (label in env.labels) {
		env = addWarning(env, q@location, "Duplicate label");	
	}
	else {
		env = addLabel(env, label);
	}
	
	return env;
}

// Type checking on expressions
TypeEnv checkExpr(Expr e, set[Type] req, TypeEnv env) {
	Type resultType = resultTypes[getName(e)];
	
	if (resultType notin req) {
		env = addError(env, e@location, "Required <toString(req)>, got <resultType>");
	}
	else if (e has val) {
		set[Type] reqTypes = requiredTypes[getName(e)];
		env = checkExpr(e.val, reqTypes, env);
	}
	else if ((e has lhs) && (e has rhs)) {
		set[Type] reqTypes = requiredTypes[getName(e)];
		env = checkExpr(e.lhs, reqTypes, env);		
		
		if (ident(name) := e.lhs) {
			if (isVariableDefined(env, name)) {
				set[Type] reqForRhs = {getTypeOfVariable(env, name)};
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

// Type checking on expressions and checking for undefined variables used in expressions
TypeEnv checkExpr(Expr e:ident(str name), set[Type] req, TypeEnv env) {                              
	if (!isVariableDefined(env, name)) {
   		env = addError(env, e@location, "Undefined variable \"<name>\"");
	}
	else {
	  	Type tp = getTypeOfVariable(env, name);
	  	if (tp notin req) {
	  		env = addError(env, e@location, "Required <toString(req)>, got <tp>");
		}
	}
	
	return env;
}
