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


private node outline(node n) {
	top-down visit (n) {
	
	case F:form(name, statements): 
		return "form"(getNodesFromStatements(statements))
				[@label="Form <name>"][@\loc=F@location]; 
	
	case R:regular(_, name, _): 
		return "regQuestion"()
		  		[@label="<name>"][@\loc=R@location];
	
	case C:computed(_, name, _, _): 
		return "regQuestion"()
				[@label="<name>"][@\loc=C@location];
	
	// note: label is only the first condition, any further "else if"s are ignored
	case I:conditional(ifStatement, _, _): 
		return "condQuestion"(getNodesFromStatements(flatten(I)))
				[@label=unparse(I.ifStatement.condition)][@\loc=I@location];
	
	default: 
		throw IllegalArgument();
	}
}


private list[node] getNodesFromStatements(list[Statement] s) 
  = ["regular"([outline(r) | r <- separate(s).regs])[@label="Regular (<size(separate(s).regs)>)"],
	 "computed"([outline(c) | c <- separate(s).comps])[@label="Computed (<size(separate(s).comps)>)"],
	 "conditional"([outline(c) | c <- separate(s).conds])[@label="Conditional (<size(separate(s).conds)>)"]];

// needed for the conditional label; 
// it's impossible to use library functions because the expression is already imploded 
private str unparse(Expr expr) {
	top-down visit (expr) {
	case ident(name): return name;
	case \int(val): return "<val>";
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
	default: return "";
	}
}






