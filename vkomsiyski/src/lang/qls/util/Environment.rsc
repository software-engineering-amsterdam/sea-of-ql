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


public VarRules getAllVarRules(Declarations d, StyleEnvironment env) {
	varRules = env.varRules;
	for (name <- d, name notin varRules, d[name].\type in env.typeRules)
		varRules += (name : env.typeRules[d[name].\type]);
	return varRules;
}


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
	grouped_questions = [];
	if (name in env.groups)
		messages += {duplicateGroupError(name, r@location)};
	for (q <- questions)
		if (q notin grouped_questions) 
			grouped_questions += q;
		else	
			messages += {inGroupError(q, r@location)};
	for (q1 <- questions, previous <- env.groups, q2 <- env.groups[previous], q1 == q2)
		messages += {inGroupError(q1, r@location)};
				
	return <(),(),(name : grouped_questions),messages>;
}


private set[Message] checkRules(Type t, list[Rule] rules) {
	messages = {};
	found_rules = [];
	for (r <- rules) {
		messages += checkRule(r, found_rules);
		found_rules += r;
	}
	
	for (r1 <- rules, !compatible(t, r1))
		messages += {typeError(t.name, r1@location)};
	for (r1 <- rules, r2 <- rules, r1 != r2, r1 := r2)
		messages += {redeclaredRuleError(r1.name, r1@location),
					 redeclaredRuleError(r2.name, r2@location)};
	return messages;
}



private set[Message] checkRule(Rule rule:color(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, color(_) := r};

private set[Message] checkRule(Rule rule:font(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, font(_) := r};
  
private set[Message] checkRule(Rule rule:widget(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, widget(_) := r};

private set[Message] checkRule(Rule rule:minInt(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, minInt(_) := r};
  
private set[Message] checkRule(Rule rule:maxInt(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, maxInt(_) := r};

private set[Message] checkRule(Rule rule:stepInt(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, stepInt(_) := r};

private set[Message] checkRule(Rule rule:minFloat(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, minFloat(_) := r};
  
private set[Message] checkRule(Rule rule:maxFloat(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, maxFloat(_) := r};

private set[Message] checkRule(Rule rule:stepFloat(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, stepFloat(_) := r};
  
private set[Message] checkRule(Rule rule:minDate(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, minDate(_) := r};
  
private set[Message] checkRule(Rule rule:maxDate(_), list[Rule] rules) 
  = {ruleError(rule@location) | r <- rules, maxDate(_) := r};

