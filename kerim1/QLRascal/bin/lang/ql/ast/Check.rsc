module lang::ql::ast::Check

import lang::ql::ast::AST;
import lang::ql::ast::Pretty;

import Prelude;
import Message;

// Environment that contains all relevant information for checking an abstract syntax tree
alias Env = tuple[
	map[str, Type] questionVars,
	map[str, Type] computedQuestionVars,
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

// Helper functions to add values to the environment
Env addQuestionVar(Env env, str ident, Type tp) = env[questionVars = env.questionVars + (ident: tp)];
Env addComputedQuestionVar(Env env, str ident, Type tp) = env[computedQuestionVars = env.computedQuestionVars + (ident: tp)];
Env addVarsDependencies(Env env, str ident, set[str] dependencies) = env[varsDependencies = env.varsDependencies + (ident: dependencies)];
Env addExpression(Env env, Expr expression, Type tp) = env[expressions = env.expressions + <expression, tp>];
Env addLabel(Env env, str label) = env[labels = env.labels + label];
Env addError(Env env, loc l, str msg) = env[errors = env.errors + error(msg, l)];
Env addWarning(Env env, loc l, str msg) = env[errors = env.errors + warning(msg, l)];

bool isVariableDefined(Env env, str ident) = (ident in env.questionVars) || (ident in env.computedQuestionVars);

Type getTypeOfVariable(Env env, str ident) {
	if (ident in env.questionVars) {
		return env.questionVars[ident];
	}
	else if (ident in env.computedQuestionVars) {
		return env.computedQuestionVars[ident];
	}
}

set[str] getAllIndentifiersInExpr(Expr e) = { name | ident(str name) := e };

str readableTypes(set[Type] types) = intercalate(" or ", [pretty(tp) | tp <- types]);

// Start of all functions that will check a certain part of the abstract syntax tree
public set[Message] checkForm(form(_, list[Statement] statements)) {                                                
  	Env env = <(), (), (), {}, {}, {}>;
  	
  	// Check expressions after we have gathered our type environment
  	env = (env | checkStatement(s, {}, it) | s <- statements);
	env = (env | checkExpr(e, {tp}, it) | <Expr e, Type tp> <- env.expressions);
	
	return env.errors;
}

Env checkStatement(question(Question q), set[str] identifiers, Env env) = checkQuestion(q, identifiers, env);

Env checkStatement(ifThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart), set[str] identifiers, Env env) 
	= checkIfThenElse(condition, thenPart, elseIfs, elsePart, identifiers, env);

Env checkStatement(ifThen(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs), set[str] identifiers, Env env) 
	= checkIfThenElse(condition, thenPart, elseIfs, [], identifiers, env);

Env checkIfThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart, set[str] identifiers, Env env) {	
	env = addExpression(env, condition, boolType());
	
	set[str] ids = identifiers + getAllIndentifiersInExpr(condition);
	env = (env | checkStatement(s, ids, it) | s <- thenPart);
	env = (env | checkElseIf(s, identifiers, it) | s <- elseIfs);
	return (env | checkStatement(s, identifiers, it) | s <- elsePart);
}

Env checkElseIf(elseIf(Expr condition, list[Statement] thenPart), set[str] identifiers, Env env) {
	env = addExpression(env, condition, boolType());
	
	set[str] ids = identifiers + getAllIndentifiersInExpr(condition);
	return (env | checkStatement(s, ids, it) | s <- thenPart);
}

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable 
 * and provides warnings for duplicate labels.
 */
Env checkQuestion(Question q:computed(_, _, Type tp, Expr expression), set[str] identifiers, Env env) {
	env = addExpression(env, expression, tp);
	return handleQuestion(q, identifiers, env);
}

Env checkQuestion(Question q:noncomputed(_, _, _), set[str] identifiers, Env env) 
	= handleQuestion(q, identifiers, env);

Env handleQuestion(Question q, set[str] identifiers, Env env) {
	env = checkQuestionDeclaration(q, env);
	
	if (q.identifier notin env.varsDependencies) {
		env = addVarsDependencies(env, q.identifier, identifiers);
	}
	else {
		env = addVarsDependencies(env, q.identifier, env.varsDependencies[q.identifier] & identifiers);
	}
	
	if (q.label in env.labels) {
		env = addWarning(env, q@location, "Duplicate label");	
	}
	else {
		env = addLabel(env, q.label);
	}
	
	return env;
}

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable
 */
Env checkQuestionDeclaration(Question q:computed(str identifier, str label, Type tp, Expr expression), Env env) {
	if (identifier in env.computedQuestionVars) {	
		Type declaredType = env.computedQuestionVars[identifier];
		
		if (declaredType != tp) {
			env = addError(env, q@location, "Question has already been defined before with type <pretty(declaredType)>");
		}		
	}
	else { 
		if (identifier in env.questionVars) {
			env = addError(env, q@location, "There is already a non-computed version of this question");	
		}
		
		env = addComputedQuestionVar(env, identifier, tp);
	}
	
	return env;
}

Env checkQuestionDeclaration(Question q:noncomputed(str identifier, str label, Type tp), Env env) {
	if (identifier in env.questionVars) {	
		Type declaredType = env.questionVars[identifier];
		
		if (declaredType != tp) {
			env = addError(env, q@location, "Question has already been defined before with type <pretty(declaredType)>");
		}		
	}
	else { 
		if (identifier in env.questionVars) {
			env = addError(env, q@location, "There is already a computed version of this question");	
		}
		
		env = addQuestionVar(env, identifier, tp);
	}
	
	return env;
}

// Type checking on expressions
Env checkExpr(Expr e, set[Type] req, Env env) {
	Type resultType = resultTypes[getName(e)];
	
	if (resultType notin req) {
		env = addError(env, e@location, "Required <readableTypes(req)>, got <pretty(resultType)>");
	}
	else if (e has val) {
		env = checkUnaryExpr(e, env);
	}
	else if ((e has lhs) && (e has rhs)) {
		env = checkBinaryExpr(e, env);
	}
	
	return env;
}

Env checkUnaryExpr(Expr e, Env env) {
	set[Type] reqTypes = requiredTypes[getName(e)];
	return checkExpr(e.val, reqTypes, env);
}

Env checkBinaryExpr(Expr e, Env env) {
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
Env checkExpr(Expr e:ident(str name), set[Type] req, Env env) {                              
	if (!isVariableDefined(env, name)) {
   		env = addError(env, e@location, "Undefined variable \"<name>\"");
	}
	else {
	  	Type tp = getTypeOfVariable(env, name);
	  	if (tp notin req) {
	  		env = addError(env, e@location, "Required <readableTypes(req)>, got <pretty(tp)>");
		}
		
		for (str identifier <- env.varsDependencies[name]) {
			if ((identifier in env.varsDependencies) && (name in env.varsDependencies[identifier])) {
				env = addError(env, e@location, "Cyclic dependency for <name> and <identifier>");
			}	
		}		
	}
	
	return env;
}
