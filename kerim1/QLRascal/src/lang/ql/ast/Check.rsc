module lang::ql::ast::Check

import lang::ql::ast::AST;
import lang::ql::ast::Pretty;

import Prelude;
import Message;

import IO;

// Environment that contains all relevant information for checking an abstract syntax tree
alias Env = tuple[
	map[str, Type] questionVars,
	map[str, Type] computedQuestionVars,
	map[str, set[str]] varsDependOn, 
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
Env addVarsDependOn(Env env, str variable, set[str] depending) = env[varsDependOn = env.varsDependOn + (variable: depending)];
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

set[str] getAllIndentifiersInExpr(Expr e) {
	set[str] identifiers = {};
	
	visit (e) {
		case \ident(str name): identifiers += name;
	}
	
	return identifiers;
}

str readableTypes(set[Type] types) = intercalate(" or ", [pretty(tp) | tp <- types]);

// Start of all functions that will check a certain part of the abstract syntax tree
public set[Message] checkForm(form(_, list[Statement] statements)) {                                                
  	Env env = <(), (), (), {}, {}, {}>;
  	
	for (s <- statements) {
		env = checkStatement(s, {}, env);
	}
	
	println(env.varsDependOn);
	
	// Now that we have gathered all type information, check all the expressions encountered
	for (<Expr e, Type tp> <- env.expressions) {
		env = checkExpr(e, {tp}, env);
	}
	
	return env.errors;
}

Env checkStatement(question(Question q), set[str] identifiers, Env env) = checkQuestion(q, identifiers, env);

Env checkStatement(Statement statement, set[str] identifiers, Env env) {
	env = addExpression(env, statement.condition, boolType());
	
	for (s <- statement.thenPart) {
		set[str] ids = identifiers + getAllIndentifiersInExpr(statement.condition);
		env = checkStatement(s, ids, env);
	}
	
	for (elseIf(Expr condition, list[Statement] thenPart) <- statement.elseIfs) {
		env = addExpression(env, condition, boolType());
		set[str] ids = identifiers + getAllIndentifiersInExpr(condition);
		
		for (s <- thenPart) {
			env = checkStatement(s, ids, env);
		}
	}
	
	if (statement has elsePart) {
		for (s <- statement.elsePart) {
			env = checkStatement(s, identifiers, env);
		}
	}
	
	return env;
}

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable 
 * and provides warnings for duplicate labels.
 */
Env checkQuestion(q:computed(str identifier, str label, Type tp, Expr expression), set[str] identifiers, Env env) {
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
	
	if (identifier notin env.varsDependOn) {
		env = addVarsDependOn(env, identifier, identifiers);
	}
	else {
		env = addVarsDependOn(env, identifier, env.varsDependOn & identifiers);
	}
	
	if (label in env.labels) {
		env = addWarning(env, q@location, "Duplicate label");	
	}
	else {
		env = addLabel(env, label);
	}
	
	env = addExpression(env, expression, tp);
	
	return env;
}

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable 
 * and provides warnings for duplicate labels.
 */
Env checkQuestion(q:noncomputed(str identifier, str label, Type tp), set[str] identifiers, Env env) {
	if (identifier in env.questionVars) {	
		Type declaredType = env.questionVars[identifier];
		
		if (declaredType != tp) {
			env = addError(env, q@location, "Question has already been defined before with type <pretty(declaredType)>");
		}		
	}
	else { 
		if (identifier in env.computedQuestionVars) {
			env = addError(env, q@location, "There is already a computed version of this question");	
		}
		
		env = addQuestionVar(env, identifier, tp);
	}
	
	if (identifier notin env.varsDependOn) {
		env = addVarsDependOn(env, identifier, identifiers);
	}
	else {
		env = addVarsDependOn(env, identifier, env.varsDependOn[identifier] & identifiers);
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
Env checkExpr(Expr e, set[Type] req, Env env) {
	Type resultType = resultTypes[getName(e)];
	
	if (resultType notin req) {
		env = addError(env, e@location, "Required <readableTypes(req)>, got <pretty(resultType)>");
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

/* Type checking on expressions, 
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
		
		for (str identifier <- env.varsDependOn[name]) {
			if (name in env.varsDependOn[identifier]) {
				env = addError(env, e@location, "Cyclic dependency for <name> and <identifier>");
			}	
		}		
	}
	
	return env;
}
