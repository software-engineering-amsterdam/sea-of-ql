module lang::ql::checker::CheckQuestions

import Message;
import lang::ql::generator::Pretty;

import lang::ql::ast::AST;
import lang::ql::ast::ExprInspector;

alias CheckQuestionEnv = tuple[
	map[str, Type] nonComputedQuestionTypes,
	map[str, Type] computedQuestionTypes,
	set[str] labels, 
	set[Message] errors
];

// Helper functions to add values to the environment
CheckQuestionEnv addNonComputedQuestionTypes(CheckQuestionEnv env, str ident, Type tp) = 
	env[nonComputedQuestionTypes = env.nonComputedQuestionTypes + (ident: tp)];
CheckQuestionEnv addComputedQuestionTypes(CheckQuestionEnv env, str ident, Type tp) = 
	env[computedQuestionTypes = env.computedQuestionTypes + (ident: tp)];
CheckQuestionEnv addLabel(CheckQuestionEnv env, str label) = 
	env[labels = env.labels + label];
CheckQuestionEnv addError(CheckQuestionEnv env, loc l, str msg) = 
	env[errors = env.errors + error(msg, l)];
CheckQuestionEnv addWarning(CheckQuestionEnv env, loc l, str msg) = 
	env[errors = env.errors + warning(msg, l)];

/* Checks for duplicate questions with different types,
 * computed and answerable questions that bind the same variable 
 * and provides warnings for duplicate labels.
 */
public set[Message] checkQuestions(Form form) {
	CheckQuestionEnv env = <(), (), {}, {}>;
	
	visit(form) {
		case Question q:
			env = checkQuestion(q, env);
	}
	
	return env.errors;
}

CheckQuestionEnv checkQuestion(Question q, CheckQuestionEnv env) {
	env = checkQuestionDeclaration(q, env);
	
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
CheckQuestionEnv checkQuestionDeclaration(Question q:computed(str identifier, str label, Type tp, Expr expression), CheckQuestionEnv env) {
	if (identifier in env.computedQuestionTypes) {	
		Type declaredType = env.computedQuestionTypes[identifier];
		
		if (declaredType != tp) {
			env = addError(env, q@location, "Question has already been defined before with type <pretty(declaredType)>");
		}
		else {
			env = addError(env, q@location, "Question has already been defined before");
		}
	}
	else { 
		if (identifier in env.nonComputedQuestionTypes) {
			env = addError(env, q@location, "There is already a non-computed version of this question");	
		}
		
		env = addComputedQuestionTypes(env, identifier, tp);
	}
	
	return env;
}

CheckQuestionEnv checkQuestionDeclaration(Question q:noncomputed(str identifier, str label, Type tp), CheckQuestionEnv env) {
	if (identifier in env.nonComputedQuestionTypes) {	
		Type declaredType = env.nonComputedQuestionTypes[identifier];
		
		if (declaredType != tp) {
			env = addError(env, q@location, "Question has already been defined before with type <pretty(declaredType)>");
		}	
		else {
			env = addError(env, q@location, "Question has already been defined before");
		}	
	}
	else { 
		if (identifier in env.computedQuestionTypes) {
			env = addError(env, q@location, "There is already a computed version of this question");	
		}
		
		env = addNonComputedQuestionTypes(env, identifier, tp);
	}
	
	return env;
}