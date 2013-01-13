module lang::ql::ide::Check

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import util::IDE;
import ParseTree;
import Message;
import Exception;
import Set;
import List;

import util::ValueUI;


/*
 Checks:
x 	- bool, int, string expressions
 	- float, date expressions 
x 	- The type of the expression of a computed question must match the declared one
x	- The expression in a conditional statement must be boolean
x 	- The expression of a computed question must not contain undeclared variables
x	- The expression in a conditional statement must not contain undeclared variables
x	- No computed question can refer to itself
	- A question must appear at most once per execution path (determinism)
	- No cyclic dependencies
x	- Multiple questions with the same name must have the same type
x	- Warning on duplicate labels
	
	???? - There must be no computed and regular questions with the same name
*/


public Contribution getAnnotator() 
  = annotator(Tree (Tree input) {
	  return input[@messages=annotate(implode(input))];
    });
    
    
alias Var = tuple[str \type, str name, str label, loc location];

alias Env = map[str name, str \type];        
    
alias Dep = tuple[str name, Expr expr];    

    
private Message redeclError(str name, loc l) 
  = error("Variable <name> redeclared with different type", l);

private Message declError(str name, loc l) 
  = error("Variable <name> redeclared within the same execution path", l);

private Message typeError(str expected, str got, Expr e) 
  = error("Type mismatch: expected <expected> but got <got>", e@location);

private Message undeclError(Expr e:ident(name)) 
  = error("Undeclared variable: <name>", e@location);    
  
private Message selfError(loc l) 
  = error("Self-referral is not allowed", l);
  
private Message duplLabel(loc l) 
  = warning("Duplicate label", l);
    

private set[Message] annotate(node input) {
	// get a list of declared questions as tuples
	vars = getVars(input); 
	// check for incosistent redeclarations
	err = {redeclError(v1.name, v1.location), redeclError(v2.name, v2.location) |
			v1 <- vars, v2 <- vars, v1.name == v2.name, v1.\type != v2.\type};
	if (!isEmpty(err))	return err;

	deps = getDeps(input);
	// check for cyclic dependencies
	// TODO
	// check for redeclarations on the same execution path (non-determinism)
	// TODO
	
	env = (v.name : v.\type | v <- vars);
	// check for missing declarations and type consistency
	err = checkType(input, env);
	if (!isEmpty(err))	return err;
	
	// check for computed questions referring to themselves
	err = checkSelf(input);
	if (!isEmpty(err))	return err;
	
	// check for duplicate labels
	err = {duplLabel(l1.location), duplLabel(l2.location) | 
			l1 <- vars, l2 <- vars, l1.label == l2.label}; 
	return err;
}
    
    

private list[Var] getVars(node input) {
	vars = [];
	labels = [];
	top-down visit(input) {
	case F:form(name, statements): 
		vars = vars + [<"form", name, "", F@location>];	
	case R:regular(\type, name, label):
		vars = vars + [<\type, name, label, R@location>]; 
	case C:computed(\type, name, label, _):
		vars = vars + [<\type, name, label, C@location>];
	}
	return vars;
}



private list[Dep] getDeps(node input) {
	deps = [];
	top-down-break visit (input) {
	case form(_, statements):
		deps = deps + [d | s <- statements, d <- addDep(s, \bool(true))];
	}
	// put all reocurring question expressions in lists
	deps = dup([<n, [e | <n,e> <- deps]> | <n, _> <- deps]);
	// discard unique questions
	deps = [<n, l> | <n ,l> <- deps, size(l) > 1];
	text(deps);
	return deps;
}


public list[Dep] addDep(Statement s, Expr expr) {

	top-down-break visit (s) {
	case regular(_,name,_): return [<name, expr>];
	case computed(_,name,_,_): return [<name, expr>];
	case C:conditional(ifStatement, [], elsePart):
		return 	[d | st <- C.ifStatement.body, d <- addDep(st, and(expr, C.ifStatement.condition))] +
				[d | st <- C.elsePart, d <- addDep(st, and(expr, not(C.ifStatement.condition)))];
	case C:conditional(ifStatement, elseIfs, elsePart):
		return 	[d | st <- C.ifStatement.body, d <- addDep(st, and(expr, C.ifStatement.condition))] +
				addDep(conditional(head(C.elseIfs), tail(C.elseIfs), C.elsePart), and(expr, not(C.ifStatement.condition)));		    	
	}
}



public set[Message] checkType(node input, Env env) {
	err = {};
	top-down visit (input) { 
	case C:computed(\type,_,_,expr): 
		err = err + expect(\type, expr, env);
	case C:conditional(ifStatement,[],_):
		err = err + expect("bool", C.ifStatement.condition, env);
	case C:conditional(ifStatement,elseIfs,elsePart):
		err = err + expect("bool", C.ifStatement.condition, env) +
   			  checkType(conditional(head(C.elseIfs), tail(C.elseIfs), C.elsePart), env);
	}
	return err;
}
 


public set[Message] checkSelf(node input) {
	err = {};
	visit (input) {
	case C:computed(_,name,_,expr):
		visit (C.expr) {
		case ident(var): 
			if (C.name == var) 
				err = err + selfError(C@location);
		}
	}
	return err;
}

 
 
public set[Message] expect(str t, Expr e, Env env) {
	err = {};
 	top-down-break visit (e) {
 	
 	case ident(name): 
 		if (!env[name]?)
 			err = err + undeclError(e);
 		else if (t != env[name])
 			err = err + typeError(t, env[name], e);
 	case \int(_): 
 		err = err + ((t == "int")? {} : typeError(t, "int", e));
 	case string(_): 
 		err = err + ((t == "string")? {} : typeError(t, "string", e)); 
 	case \bool(_): 
 		err = err + ((t == "bool")? {} : typeError(t, "bool", e)); 
 	case pos(e): 
 		err = err + ((t == "int")? expect("int", e, env) : typeError(t, "int", e));  
 	case neg(e): 
 		err = err + ((t == "int")? expect("int", e, env) : typeError(t, "int", e));  
 	case not(e): 
 		err = err + ((t == "bool")? expect("bool", e, env) : typeError(t, "bool", e));  
  	case mul(e1, e2): 
  		err = err + ((t == "int")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "int", e));  
  	case div(e1, e2): 
   		err = err + ((t == "int")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "int", e));  
  	case add(e1, e2): 
   		err = err + ((t == "int")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "int", e));  
  	case sub(e1, e2): 
   		err = err + ((t == "int")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "int", e));  
 	case lt(e1, e2): 
  		err = err + ((t == "bool")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "bool", e));  
	case leq(e1, e2): 
  		err = err + ((t == "bool")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "bool", e));  
	case gt(e1, e2): 
  		err = err + ((t == "bool")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "bool", e));  
 	case geq(e1, e2): 
  		err = err + ((t == "bool")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "bool", e));  
 	case eq(e1, e2): 
  		err = err + ((t == "bool")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "bool", e));  
 	case neq(e1, e2): 
  		err = err + ((t == "bool")? expect("int", e1, env) + expect("int", e2, env) : typeError(t, "bool", e));  
 	case and(e1, e2): 
  		err = err + ((t == "bool")? expect("bool", e1, env) + expect("bool", e2, env) : typeError(t, "bool", e));  
 	case or(e1, e2): 
  		err = err + ((t == "bool")? expect("bool", e1, env) + expect("bool", e2, env) : typeError(t, "bool", e));  
 	default: throw IllegalArgument();
 	}
 	return err;
}
 
 
 
