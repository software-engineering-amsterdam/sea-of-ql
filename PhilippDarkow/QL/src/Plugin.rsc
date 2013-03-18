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

private str QL_NAME = "QL";
private str QL_EXT = "ql";

//  Define connection with the QL checkers
public Program checkQLProgram(Program x) {
	p = implodeProgram(#Program, x);
	env = checkProgram(p);
	errors = { error(v, l) | <loc l, PicoId v> <- env.errors };
	if(!isEmpty(errors))
		return x[@messages = errors];
    ids = uninitProgram(p);
	warnings = { warning("Variable <v> maybe uninitialized", l) | <loc l, PicoId v, STATEMENT s> <- ids };
	return x[@messages = warnings];
}

//  Define connection with CFG visualization
public void visualizeQLProgram(Tree x, loc selection) {
	m = implodeProgram(x); 
	println("call to viz");
	CFG = cflowProgram(m);
	render(visCFG(CFG.graph));
}
	
//  Register the QL tools
public void registerQL() {
  registerLanguage(QL_NAME, QL_EXT, Tree(str src, loc l) {
     return parseProgram(src, l);
  });

  registerContributions(QL_NAME, {
    	outliner(node (Tree t) {
			return outline(implodeProgram(t));
			}
		),

		menu(menu("QL",[
		    action("Generate QL Program", generateQL),
		    action("Visualize Programm", visualizeQLProgram)
	    ])
  	),
	annotator(Tree (Tree t) {
			
			return t[@messages = checkingQL(implodeProgram(t))];
  		})
  	}); 
}

public void generateQL(Tree x, loc selection) {
	generateQLForm(implodeProgram(x));
}