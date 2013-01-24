module lang::ql::ide::Check

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::util::Typecheck;
import lang::ql::util::Message;
import util::IDE;
import ParseTree;
import Message;
import Set;
import List;



public Contribution getAnnotator() 
  = annotator(Tree (Tree input) {
	  return input[@messages=annotate(implode(input))];
    });
    
    
 
alias Var = tuple[str \type, str name, str label, loc location];

alias ExpOccurence = tuple[str \type, Expr expr];

alias Environment = tuple[list[value] app, list[Var] vars, list[ExpOccurence] exps];

alias VarMap = map[str name, str \type];        
    

    
// return a subset of all errors in order not to cluster with error messages
private set[Message] annotate(node input) {

	// making a list of vars and expressions in order of appearance
	env = getEnvironment(input);
	
	// check if a variable is referenced before it's declared (fixes cyclic dependencies)
	msgs = checkDeclarationOrder(env.app);
	if (!isEmpty(msgs))	return msgs;
	
	// check if a variable is declared inconsistently with a different type
	msgs = checkRedeclarations(env.vars);
	if (!isEmpty(msgs))	return msgs;
			  		
	// create a mapping between variable names and their types
	vars = ( v.name : v.\type | v <- env.vars);
	
	// check expressions types
	msgs = checkTypes(env.exps, vars);
	if (!isEmpty(msgs))	return msgs;
			  
	// check for duplicate labels
	msgs = checkLabels(env.vars);
	return msgs;
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
				err += undeclaredError(name, e@location);
		} 
	return err;
}
 
// check for type inconsistency with declarations 
private set[Message] checkRedeclarations(list[Var] vars) =
	{redeclaredError(v1.name, v1.location), redeclaredError(v2.name, v2.location) |
	 v1 <- vars, v2 <- vars, v1.name == v2.name, v1.\type != v2.\type};

// check expression types
private set[Message] checkTypes(list[ExpOccurence] exps, VarMap vars) =
	{typeError(occurence.\type, occurence.expr@location) |
	 occurence <- exps, !expected(occurence.\type, occurence.expr, vars)};

// check for duplicate labels
private set[Message] checkLabels(list[Var] vars) =
	{duplicateLabel(l1.location), duplicateLabel(l2.location) | 
	 l1 <- vars, l2 <- vars, l1 != l2, l1.label == l2.label};
	
 
 
 
