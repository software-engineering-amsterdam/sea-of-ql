module lang::qls::util::Environment

import lang::ql::ast::AST;
import lang::ql::util::Message;
import lang::ql::util::Environment;
import lang::qls::ast::AST;
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
	messages = checkRules(rules);;
	if (name notin d) {
		messages += undeclaredError(name, r@location);
	} else {
		messages += {*compatible(d[name].\type, rule) | rule <- rules};
		if (name in env.varRules)
			messages += {redeclaredError(r@location)};
	}
	return <(), (name : rules), (), messages>;
}


private StyleEnvironment check(StyleEnvironment env, StyleRule r:typed(\type, rules), Declarations d) {
	messages = {*compatible(\type, rule) | rule <- rules} + checkRules(rules);
	if (\type in env.typeRules)
		messages += {redeclaredError(r@location)};
	
	return <(\type : rules), (), (), messages>;
}

private StyleEnvironment check(StyleEnvironment env, StyleRule r:group(name, questions), Declarations d) {
	messages = {undeclaredError(q, r@location) | q <- questions, q notin d};
	if (name in env.groups)
		messages += {redeclaredError(r@location)};
	return <(),(),(name : questions),messages>;
}




private set[Message] checkRules(list[Rule] r) {
	messages = {};
	for (r1 <- rule, r2 <- rule, r1 != r2) 
		if (r1.name == r2.name)
			messages += {redeclaredError(r1@location),
						 redeclaredError(r2@location)};
}




private set[Message] compatible(Type t, Rule r) = {};


