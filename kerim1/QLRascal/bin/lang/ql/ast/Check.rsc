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
Env checkQuestion(Question question, set[str] identifiers, Env env) {
	bool isComputed = question has expression;
	env = checkQuestionDeclaration(question, isComputed, env);
	
	if (question.identifier notin env.varsDependencies) {
		env = addVarsDependencies(env, question.identifier, identifiers);
	}
	else {
		env = addVarsDependencies(env, question.identifier, env.varsDependencies[question.identifier] & identifiers);
	}
	
	if (question.label in env.labels) {
		env = addWarning(env, question@location, "Duplicate label");	
	}
	else {
		env = addLabel(env, question.label);
	}
	
	if (isComputed) {
		env = addExpression(env, question.expression, question.tp);
	}
	
	return env;
}

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable
 */
Env checkQuestionDeclaration(Question question, bool computed, Env env) {
	if (	(computed && (question.identifier in env.computedQuestionVars)) || 
			(!computed && (question.identifier in env.questionVars))) {	
		Type declaredType;
		if (computed) {
			declaredType = env.computedQuestionVars[question.identifier];
		}
		else {
			declaredType = env.questionVars[question.identifier];	
		}
		
		if (declaredType != question.tp) {
			env = addError(env, question@location, "Question has already been defined before with type <pretty(declaredType)>");
		}		
	}
	else { 
		if (computed && (question.identifier in env.questionVars)) {
			env = addError(env, question@location, "There is already a non-computed version of this question");	
		}
		else if (!computed && (question.identifier in env.computedQuestionVars)) {
			env = addError(env, question@location, "There is already a computed version of this question");	
		}
		
		if (computed) {
			env = addComputedQuestionVar(env, question.identifier, question.tp);
		}
		else {
			env = addQuestionVar(env, question.identifier, question.tp);
		}
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
		
		for (str identifier <- env.varsDependencies[name]) {
			if ((identifier in env.varsDependencies) && (name in env.varsDependencies[identifier])) {
				env = addError(env, e@location, "Cyclic dependency for <name> and <identifier>");
			}	
		}		
	}
	
	return env;
}
