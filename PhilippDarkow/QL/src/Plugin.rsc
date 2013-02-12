module Plugin

import Prelude;
import vis::Figure;
import vis::Render;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import typeChecker::TypeCheck;
//import demo::lang::Pico::Eval;
//import demo::lang::Pico::Compile;
import visualization::ControlFlow;
import visualization::Visualize;
import ide::Uninit;
import util::IDE;
import util::ValueUI;
import util::Load;
import ParseTree;

private str LANG = "QL";
private str EXT = "q";

private str QL_NAME = "QL";
private str QL_EXT = "ql";

//  Define the connection with the Pico parser
Tree parser(str x, loc l) {
    return parse(#Program, x, l);
}

//  Define connection with the Pico checkers
// (includes type checking and uninitialized variables check)

public Program checkQLProgram(Program x) {
	println("in check program");
	p = implode(#Program, x);
	env = checkProgram(p);
	errors = { error(v, l) | <loc l, PicoId v> <- env.errors };
	if(!isEmpty(errors))
		return x[@messages = errors];
    ids = uninitProgram(p);
	warnings = { warning("Variable <v> maybe uninitialized", l) | <loc l, PicoId v, STATEMENT s> <- ids };
	return x[@messages = warnings];
}

//  Define the connection with the Pico evaluator

//public void evalPicoProgram(Program x, loc selection) {
//	m = implode(#PROGRAM, x); 
//	text(evalProgram(m));
//}

//  Define connection with the Pico compiler

//public void compilePicoProgram(Program x, loc l){
//    p = implode(#PROGRAM, x);
//    asm = compileProgram(p);
//	text(asm);
//}

//  Define connection with CFG visualization

public void visualizeQLProgram(Program x, loc selection) {
	m = implode(#Program, x); 
	CFG = cflowProgram(m);
	render(visCFG(CFG.graph));
}
	
//  Define all contributions to the QL IDE

public set[Contribution] QL_CONTRIBS = {
	popup(
		menu("Pico",[
		    //action("Evaluate Pico program", evalPicoProgram),
    		//action("Compile Pico to ASM", compilePicoProgram),
    		//action("Show Control flow graph", visualizeQLProgram)
	    ])
  	)
};

//  Register the QL tools

public void registerQL() {
  registerLanguage(QL_NAME, QL_EXT, parser);
  //registerAnnotator(QL_NAME, checkQLProgram);
  registerContributions(QL_NAME, QL_CONTRIBS);
}

public void main() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });
}
