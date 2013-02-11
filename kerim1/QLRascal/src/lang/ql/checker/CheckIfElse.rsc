module lang::ql::checker::CheckIfElse

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

public CheckEnv checkIfThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart, set[str] identifiers, CheckEnv env) {	
	env = addExpression(env, condition, boolType());
	
	set[str] ids = identifiers + getAllIndentifiersInExpr(condition);
	env = (env | checkStatement(s, ids, it) | s <- thenPart);
	env = (env | checkElseIf(s, identifiers, it) | s <- elseIfs);
	return (env | checkStatement(s, identifiers, it) | s <- elsePart);
}

public CheckEnv checkElseIf(elseIf(Expr condition, list[Statement] thenPart), set[str] identifiers, CheckEnv env) {
	env = addExpression(env, condition, boolType());
	
	set[str] ids = identifiers + getAllIndentifiersInExpr(condition);
	return (env | checkStatement(s, ids, it) | s <- thenPart);
}