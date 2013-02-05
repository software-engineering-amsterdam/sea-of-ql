module lang::ql::checker::CheckQuestions

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

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable 
 * and provides warnings for duplicate labels.
 */
public CheckEnv checkQuestion(Question q, set[str] identifiers, CheckEnv env) {
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
CheckEnv checkQuestionDeclaration(Question q:computed(str identifier, str label, Type tp, Expr expression), CheckEnv env) {
	env = addExpression(env, expression, tp);
	
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

CheckEnv checkQuestionDeclaration(Question q:noncomputed(str identifier, str label, Type tp), CheckEnv env) {
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