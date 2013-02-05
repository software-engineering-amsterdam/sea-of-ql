module lang::ql::checker::Check

import Prelude;
import Message;

import lang::ql::ast::AST;
import lang::ql::generator::Pretty;

import lang::ql::checker::CheckIfElse;
import lang::ql::checker::CheckQuestions;
import lang::ql::checker::CheckExpressions;

// Check environment that holds all relevant information for checking an abstract syntax tree
public alias CheckEnv = tuple[
	map[str, Type] questionVars,
	map[str, Type] computedQuestionVars, // We have to build the type environment ourselves to check for duplicates
	map[str, set[str]] varsDependencies,
	rel[Expr expr, Type reqType] expressions, // Store all expressions while visiting tree, to check them later
	set[str] labels, 
	set[Message] errors
];

// Helper functions to add values to the environment
public CheckEnv addQuestionVar(CheckEnv env, str ident, Type tp) = 
	env[questionVars = env.questionVars + (ident: tp)];
public CheckEnv addComputedQuestionVar(CheckEnv env, str ident, Type tp) = 
	env[computedQuestionVars = env.computedQuestionVars + (ident: tp)];
public CheckEnv addVarsDependencies(CheckEnv env, str ident, set[str] dependencies) = 
	env[varsDependencies = env.varsDependencies + (ident: dependencies)];
public CheckEnv addExpression(CheckEnv env, Expr expression, Type tp) = 
	env[expressions = env.expressions + <expression, tp>];
public CheckEnv addLabel(CheckEnv env, str label) = 
	env[labels = env.labels + label];
public CheckEnv addError(CheckEnv env, loc l, str msg) = 
	env[errors = env.errors + error(msg, l)];
public CheckEnv addWarning(CheckEnv env, loc l, str msg) = 
	env[errors = env.errors + warning(msg, l)];

public bool isVariableDefined(CheckEnv env, str ident) = 
	(ident in env.questionVars) || (ident in env.computedQuestionVars);

public Type getTypeOfVariable(CheckEnv env, str ident) {
	if (ident in env.questionVars) {
		return env.questionVars[ident];
	}
	else if (ident in env.computedQuestionVars) {
		return env.computedQuestionVars[ident];
	}
}

public set[str] getAllIndentifiersInExpr(Expr e) = 
	{ name | ident(str name) := e };

public str getReadableTypes(set[Type] types) = 
	intercalate(" or ", [pretty(tp) | tp <- types]);

public set[Message] checkForm(form(_, list[Statement] statements)) {                                                
  	CheckEnv env = <(), (), (), {}, {}, {}>;
  	
  	// Check expressions after we have gathered our type environment
  	env = (env | checkStatement(s, {}, it) | s <- statements);
	env = (env | checkExpr(e, {tp}, it) | <Expr e, Type tp> <- env.expressions);
	
	return env.errors;
}

public CheckEnv checkStatement(question(Question q), set[str] identifiers, CheckEnv env) = 
	checkQuestion(q, identifiers, env);

public CheckEnv checkStatement(ifThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart), set[str] identifiers, CheckEnv env) = 
	checkIfThenElse(condition, thenPart, elseIfs, elsePart, identifiers, env);

public CheckEnv checkStatement(ifThen(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs), set[str] identifiers, CheckEnv env) = 
	checkIfThenElse(condition, thenPart, elseIfs, [], identifiers, env);