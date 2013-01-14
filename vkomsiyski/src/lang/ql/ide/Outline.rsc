module lang::ql::ide::Outline

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import util::IDE;
import ParseTree;
import List;
import Exception;


public Contribution getOutliner() 
  = outliner(node(Tree input) {
	  return "outline"(outline(implode(input)));
    });


private node outline(node input) {
	top-down-break visit (input) {
	
	case F:form(name, statements): 
		return "form"(getNodesFromStatements(statements))
				[@label="Form <name>"][@\loc=F@location]; 
	
	case R:regular(_, name, _): 
		return "regQuestion"()
		  		[@label="<name>"][@\loc=R@location];
	
	case C:computed(_, name, _, _): 
		return "regQuestion"()
				[@label="<name>"][@\loc=C@location];
	
	// note: label is only the first condition, any further "else if"s fall in the same category
	case C:conditional(ifStatement, _, _): 
		return "condQuestion"(getNodesFromStatements(flatten(C)))
				[@label=unparse(C.ifStatement.condition)][@\loc=C@location];
	
	default: 
		throw IllegalArgument();
	}
}


private list[node] getNodesFromStatements(list[Statement] s) 
  = ["regular"([outline(r) | r <- separate(s).regs])
  			  [@label="Regular Questions (<size(separate(s).regs)>)"],
	 "computed"([outline(c) | c <- separate(s).comps])
	 		   [@label="Computed Questions (<size(separate(s).comps)>)"],
	 "conditional"([outline(c) | c <- separate(s).conds])
	 			  [@label="Conditionals (<size(separate(s).conds)>)"]];


// return a list of all top level statements contained in a conditional
private list[Statement] flatten(Statement s:conditional(i,[],e)) = s.ifStatement.body + e;  
private list[Statement] flatten(Statement s:conditional(i,ei,e)) 
  = s.ifStatement.body + flatten(conditional(head(ei), tail(ei), e));  


// return a tuple with groups of different kinds of statements
private SeparatedStatements separate(list[Statement] s) = 
  <[r | r:regular(_,_,_) <- s], [c | c:computed(_,_,_,_) <- s], [c | c:conditional(_,_,_) <- s]>;


// needed for the conditional label; 
// it's impossible to use library functions because the expression is already imploded 
private str unparse(Expr expr) {
	switch (expr) {
	case ident(name): return name;
	case \int(val): return "<val>";
	case \bool(val): return "<val>";
	case string(val): return val;
	case float(val): return "<val>";
	case date(val): return val;
	case pos(e): return "+" + unparse(e);
	case neg(e): return "-" + unparse(e);
	case not(e): return "!" + unparse(e);
	case mul(e1, e2): return unparse(e1) + "*" + unparse(e2);
	case div(e1, e2): return unparse(e1) + "/" + unparse(e2);
	case add(e1, e2): return unparse(e1) + "+" + unparse(e2);
	case sub(e1, e2): return unparse(e1) + "-" + unparse(e2);
	case lt(e1, e2): return unparse(e1) + "\<" + unparse(e2);
	case leq(e1, e2): return unparse(e1) + "\<=" + unparse(e2);
	case gt(e1, e2): return unparse(e1) + "\>" + unparse(e2);
	case geq(e1, e2): return unparse(e1) + "\>=" + unparse(e2);
	case eq(e1, e2): return unparse(e1) + "==" + unparse(e2);
	case neq(e1, e2): return unparse(e1) + "!=" + unparse(e2);
	case and(e1, e2): return unparse(e1) + "&&" + unparse(e2);
	case or(e1, e2): return unparse(e1) + "||" + unparse(e2);
	default: throw IllegalArgument();
	}
}


