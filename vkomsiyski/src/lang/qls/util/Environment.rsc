module lang::qls::util::Environment

import lang::ql::ast::AST;
import lang::ql::util::Environment;
import lang::qls::ast::AST;
import lang::qls::util::Compatible;
import lang::qls::util::Message;
import Message;

alias TypeRules = map[Type, list[Rule]];

alias VarRules = map[str, list[Rule]];

alias Groups = map[str, list[str]];

alias StyleEnvironment = tuple[TypeRules typeRules,
								 VarRules varRules,
								 Groups groups,
						 		 set[Message] messages];



public StyleEnvironment getStyleEnvironment(FormStyle style, Form form) {
	StyleEnvironment stylenv = <(),(),(),{}>;
	
	env = getEnvironment(form);
	
	for (rule <- style.rules)
		stylenv = add(stylenv, check(stylenv, rule, env.declarations));
		
	return stylenv;
}

private StyleEnvironment add(StyleEnvironment current, StyleEnvironment additional) =
	<current.typeRules + additional.typeRules,
	 current.varRules + additional.varRules,
	 current.groups + additional.groups,
	 current.messages + additional.messages>;
	 
private StyleEnvironment check(StyleEnvironment env, StyleRule r:id(name, rules), Declarations d) {
	messages = {};
	if (name notin d) {
		messages += undeclaredError(name, r@location);
	} else {
		messages += checkRules(d[name].\type, rules);
		if (name in env.varRules)
			messages += {redeclaredError(name, r@location)};
	}
	return <(), (name : rules), (), messages>;
}


private StyleEnvironment check(StyleEnvironment env, StyleRule r:typed(\type, rules), Declarations d) {
	messages = checkRules(\type, rules);
	if (\type in env.typeRules)
		messages += {redeclaredError(\type.name, r@location)};
	
	return <(\type : rules), (), (), messages>;
}

private StyleEnvironment check(StyleEnvironment env, StyleRule r:group(name, questions), Declarations d) {
	messages = {undeclaredError(q, r@location) | q <- questions, q notin d};
	if (name in env.groups)
		messages += {duplicateGroupError(name, r@location)};
	return <(),(),(name : questions),messages>;
}


private set[Message] checkRules(Type t, list[Rule] rules) {
	messages = {};
	for (r1 <- rules) {
		if (!compatible(t, r1))
			messages += {typeError(t.name, r1@location)};
		for (r2 <- rules, r1 != r2, r1 := r2)
			messages += {redeclaredRuleError(r1.name, r1@location),
						 redeclaredRuleError(r2.name, r2@location)};
	}
	return messages;
}
