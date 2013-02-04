module lang::ql::ast::TypeEnvironment

import lang::ql::ast::AST;

public alias TypeEnv = 	tuple[
							map[str, Type] computedQuestions,
							map[str, Type] noncomputedQuestions
						];

public TypeEnv getTypeEnvironment(Form form) {
	TypeEnv env = <(), ()>;
	
	visit (form) {
		case computed(str identifier, _, Type tp, _): env.computedQuestions[identifier] = tp;
		case noncomputed(str identifier, _, Type tp): env.noncomputedQuestions[identifier] = tp;
 	}
	
	return env;
}

public bool isInTypeEnvironment(str identifier, TypeEnv env) = 
	(identifier in env.computedQuestions) || (identifier in env.noncomputedQuestions);
	
public Type getTypeForIdentifier(str identifier, TypeEnv env) {
	if (identifier in env.computedQuestions) {
		return env.computedQuestions[identifier];
	}
	else if (identifier in env.noncomputedQuestions) {
		return env.noncomputedQuestions[identifier];
	}
}