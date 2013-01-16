module lang::ql::ide::Check

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::util::Typecheck;
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
x 	- float, date expressions 
x 	- The type of the expression of a computed question must match the declared one
x	- The expression in a conditional statement must be boolean
x 	- The expression of a computed question must not contain undeclared variables
x	- The expression in a conditional statement must not contain undeclared variables
x	- No computed question can refer to itself
	- A question must appear at most once per execution path (determinism)
x	- No cyclic dependencies -> do not allow a variable to be referenced before declared
x	- Multiple questions with the same name must have the same type
x	- Warning on duplicate labels
	
	???? - There must be no computed and regular questions with the same name
*/


public Contribution getAnnotator() 
  = annotator(Tree (Tree input) {
	  return input[@messages=annotate(implode(input))];
    });
    
    
 
alias Var = tuple[str \type, str name, str label, loc location];

alias ExpOccurence = tuple[str \type, Expr expr];

alias Environment = tuple[list[value] app, list[Var] vars, list[ExpOccurence] exps];

alias VarMap = map[str name, str \type];        
    

private Message undeclaredError(Expr e:ident(name)) 
  = error("Undeclared variable: <name>", e@location);  

private Message redeclaredError(str name, loc l) 
  = error("Variable <name> redeclared with different type", l);
    
private Message typeError(str \type, Expr e) 
  = error("Type mismatch: <\type> required", e@location);
  
private Message duplicateLabel(loc l) 
  = warning("Duplicate label", l);

    
// return a subset of all errors in order not to cluster with error messages
private set[Message] annotate(node input) {

	// making a list of vars and expressions in order of appearance
	env = getEnvironment(input);
	
	// check if a variable is referenced before it's declared (fixes cyclic dependencies)
	msg = checkDeclarationOrder(env.app);
	if (!isEmpty(msg))	return msg;
	
	// check if a variable is declared inconsistently with a different type
	msg = checkRedeclarations(env.vars);
	if (!isEmpty(msg))	return msg;
			  		
	// create a mapping between variable names and their types
	vars = ( v.name : v.\type | v <- env.vars);
	
	// check expressions types
	msg = checkTypes(env.exps, vars);
	if (!isEmpty(msg))	return msg;
			  
	// check for duplicate labels
	msg = checkLabels(env.vars);
	return msg;
}
        
    
// get all variable declarations, expression occurences, and their order of appearance
private Environment getEnvironment(node input) {
	list[value] app = [];
	vars = [];
	exps = [];
	top-down visit (input) {
		case F:form(name, statements):  
			vars += <"form", name, "", F@location>;			
		case R:regular(\type, name, label): {
			vars += <\type, name, label, R@location>; 
			app += name;
		}	
		case C:computed(\type, name, label, expr): {
			vars += <\type, name, label, C@location>;
	 		app += [expr, name];
	 		exps += <\type, expr>;
	 	}
		case C:conditional(_,_,_): {
			app += C.\if.condition + [c.condition | c <- C.elseIfs];
			exps += <"bool", C.\if.condition> + [<"bool", c.condition> | c <- C.elseIfs];
		}
	}
	return <app, vars, exps>;
}    
 
 
// check for undeclared variables 
private set[Message] checkDeclarationOrder(list[value] env) {
	err = {};
	for (value val <- env)
		visit(val) {
		case e:ident(name): 
			if (indexOf(env, name) < 0 || indexOf(env, name) > indexOf(env, val))
				err += undeclaredError(e);
		} 
	return err;
}
 
// check for type inconsistency with declarations 
private set[Message] checkRedeclarations(list[Var] vars) =
	{redeclaredError(v1.name, v1.location), redeclaredError(v2.name, v2.location) |
	 v1 <- vars, v2 <- vars, v1.name == v2.name, v1.\type != v2.\type};


// check for duplicate labels
private set[Message] checkLabels(list[Var] vars) =
	{duplicateLabel(l1.location), duplicateLabel(l2.location) | 
	 l1 <- vars, l2 <- vars, l1 != l2, l1.label == l2.label};
	
	
// check expression types
private set[Message] checkTypes(list[ExpOccurence] exps, VarMap vars) =
	{typeError(occurence.\type, occurence.expr) |
	 occurence <- exps, !expected(occurence.\type, occurence.expr, vars)};







// TODO: redeclaration withing the same execution path


/*


alias Dep = tuple[str name, list[Expr] expr];    



  
  
private Message declError(str name, loc l) 
  = error("Variable <name> redeclared within the same execution path", l);





private list[Dep] getDeps(node input) {
	deps = [];
	top-down-break visit (input) {
	case form(_, statements):
		deps = deps + [d | s <- statements, d <- addDep(s, \bool(true))];
	}
	// put all reocurring question expressions in lists
	deps = dup([<n, [e | <n,el> <- deps, e <- el]> | <n, _> <- deps]);
	// discard unique questions
	deps = [<n, l> | <n ,l> <- deps, size(l) > 1];
	text(deps);
	return deps;
}


public list[Dep] addDep(Statement s, Expr expr) {

	top-down-break visit (s) {
	case regular(_,name,_): return [<name, [expr]>];
	case computed(_,name,_,_): return [<name, [expr]>];
	case C:conditional(ifStatement, [], elsePart):
		return 	[d | st <- C.ifStatement.body, d <- addDep(st, and(expr, C.ifStatement.condition))] +
				[d | st <- C.elsePart, d <- addDep(st, and(expr, not(C.ifStatement.condition)))];
	case C:conditional(ifStatement, elseIfs, elsePart):
		return 	[d | st <- C.ifStatement.body, d <- addDep(st, and(expr, C.ifStatement.condition))] +
				addDep(conditional(head(C.elseIfs), tail(C.elseIfs), C.elsePart), and(expr, not(C.ifStatement.condition)));		    	
	}
}*/

 
 
 
