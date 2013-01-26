module lang::ql::util::Environment

import lang::ql::ast::AST;
import lang::ql::util::Message;
import Message;

alias Declarations = map[str, tuple[Type \type, str label, loc location]];

alias References = map[Expr expr, Type \type];

alias Environment = tuple[Declarations declarations, References references, set[Message] messages];



public Environment getEnvironment(node input) {
	env = <(),(),{}>;
	
	top-down visit (input) {
		case R:regular(\type, name, label):
			env = add(env, checkDeclaration(env, name, \type, label, R@location));
		case C:computed(\type, name, label, expr): {
			env = add(env, checkExpression(env, expr, \type));
			env = add(env, checkDeclaration(env, name, \type, label, C@location));
		}
		case C:conditional(_,_,_): {
			env = add(env, checkExpression(env, C.\if.condition, \bool("bool")));
			for (c <- C.elseIfs, e <- c.condition) 
				env = add(env, checkExpression(env, e, \bool("bool")));
		}
	}
	return env;
}


private Environment add(Environment current, Environment additional) =
	<current.declarations + additional.declarations,
	 current.references + additional.references,
	 current.messages + additional.messages>;
	 


private Environment checkDeclaration(Environment env, str name, Type \type, str label, loc location) {
	messages = {};
	if (name in env.declarations && env.declarations[name].\type != \type) 
		messages += {redeclaredError(name, location), 
					 redeclaredError(name, env.declarations[name].location)};

	for (var <- env.declarations, env.declarations[var].label == label)
		messages += {duplicateLabel(location), 
					 duplicateLabel(env.declarations[var].location)};	

	return <(name: <\type, label, location>), (), messages>;
}



private Environment checkExpression(Environment env, Expr expr, Type \type) {
	messages = {};
	
	if (expr in env.references && env.references[expr] != \type) 
		messages += {redeclaredError(expr@location)};
	
	visit(expr) {
		case e:ident(name): 
			if (name notin env.declarations)
				messages += undeclaredError(name, e@location);
	}
	return <(), (expr : \type), messages>;
}


