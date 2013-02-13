module lang::ql::ast::VariableDependencies

import lang::ql::ast::AST;
import lang::ql::ast::ExprInspector;

public alias VarDependencies = map[str, set[str]];

public VarDependencies getVarDependencies(Form form) = 
	(() | checkStatement(s, {}, it) | s <- form.body);

VarDependencies checkStatement(question(Question q), set[str] identifiers, VarDependencies varsDependencies) = 
	checkQuestion(q, identifiers, varsDependencies);

VarDependencies checkStatement(ifThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart), set[str] identifiers, VarDependencies varsDependencies) = 
	checkIfThenElse(condition, thenPart, elseIfs, elsePart, identifiers, varsDependencies);

VarDependencies checkStatement(ifThen(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs), set[str] identifiers, VarDependencies varsDependencies) = 
	checkIfThenElse(condition, thenPart, elseIfs, [], identifiers, varsDependencies);

VarDependencies checkIfThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart, set[str] identifiers, VarDependencies varsDependencies) {	
	set[str] ids = identifiers + getAllIndentifiersInExpr(condition);
	varsDependencies = (varsDependencies | checkStatement(s, ids, it) | s <- thenPart);
	varsDependencies = (varsDependencies | checkElseIf(s, identifiers, it) | s <- elseIfs);
	return (varsDependencies | checkStatement(s, identifiers, it) | s <- elsePart);
}

VarDependencies checkElseIf(elseIf(Expr condition, list[Statement] thenPart), set[str] identifiers, VarDependencies varsDependencies) {
	set[str] ids = identifiers + getAllIndentifiersInExpr(condition);
	return (varsDependencies | checkStatement(s, ids, it) | s <- thenPart);
}

VarDependencies checkQuestion(Question q, set[str] identifiers, VarDependencies varsDependencies) {
	if (q.identifier notin varsDependencies) {
		varsDependencies[q.identifier] = identifiers;
	}
	else {
		varsDependencies[q.identifier] = varsDependencies[q.identifier] & identifiers;
	}
	
	return varsDependencies;	
}