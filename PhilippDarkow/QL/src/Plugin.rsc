module Plugin

import Prelude;
import vis::Figure;
import vis::Render;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import typeChecker::TypeCheck;
import controlFlow::ControlFlow;
import visualization::Visualize;
import ide::Uninit;
import util::IDE;
import util::ValueUI;
import util::Parse;
import util::Implode;
import ParseTree;
import template::StringTemplate;
import visualization::Outline;

private str LANG = "QL";
private str EXT = "q";

private str QL_NAME = "QL";
private str QL_EXT = "ql";

//  Define the connection with the QL parser
Tree parser(str x, loc l) {
    return parse(#Program, x, l);
}

//  Define connection with the QL checkers
public Program checkQLProgram(Program x) {
	println("in check program");
	p = implodeProgram(#Program, x);
	env = checkProgram(p);
	errors = { error(v, l) | <loc l, PicoId v> <- env.errors };
	if(!isEmpty(errors))
		return x[@messages = errors];
    ids = uninitProgram(p);
	warnings = { warning("Variable <v> maybe uninitialized", l) | <loc l, PicoId v, STATEMENT s> <- ids };
	return x[@messages = warnings];
}

//  Define the connection with the QL evaluator
//public void evalPicoProgram(Program x, loc selection) {
//	m = implode(#PROGRAM, x); 
//	text(evalProgram(m));
//}

//  Define connection with CFG visualization
//public void visualizeQLProgram(Program x, loc selection) {
//	m = implode(#Program, x); 
//	CFG = cflowProgram(m);
//	render(visCFG(CFG.graph));
//}
	
//  Define all contributions to the QL IDE
public set[Contribution] QL_CONTRIBS = {
	popup(
		menu("QL",[
		    //action("Evaluate Pico program", evalPicoProgram),
    		//action("Show Control flow graph", visualizeQLProgram)
	    ])
  	)
};

//  Register the QL tools
public void registerQL() {
	println("in main");
  registerLanguage(QL_NAME, QL_EXT, Tree(str src, loc l) {
     println("In register");
     return parseProgram(src, l);
  });

  registerContributions(QL_NAME, {
    	outliner(node (Tree t) {
    		println("t is :<t>");
			return outline(implodeProgram(t));
			}
		),

		menu(menu("QL",[
		    action("Generate JavaScript", generateQL)
	    ])
  	),

	annotator(Tree (Tree t) {
			println("TREE IS : <t>");
			return t[@messages = semanticCheck(implodeProgram(t))];
  		})
  	}); 
}

public void generateQL(Tree x, loc selection) {
	println("tree : <x>");
}