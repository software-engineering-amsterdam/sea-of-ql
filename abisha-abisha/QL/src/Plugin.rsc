//still working on this 

module Plugin

import Prelude;
import vis::Figure;
import vis::Render;
import syntax::abstractSyntax;
import syntax::ConcreteSyntax;
import TypeChecker::QuestionChecker;
import TypeChecker::ExpressionChecker;
import TypeChecker::Evaluate;
import Compiler::Compile;
import Visualization::ControlFlow;
import Visualization::Visualize;
import IDE::QLang;
import util::IDE;
import util::ValueUI;
import load::Load;
import ParseTree;

private str LANG = "QL";
private str EXT = "q";

private str QL_NAME = "QL";
private str QL_EXT = "ql";

//  Define the connection with the QL parser
Tree parser(str x, loc l) 
{
	return parse(#Program, x, l);
}

//  Define connection with the QL checkers
// (includes type checking and uninitialized variables check)

public Program checkQLProgram(Program x) 
{
	p = implode(#Program, x);
	env = checkProgram(p);
	errors = 
	{
	error(v, l) | <loc l, PicoId v> <- env.errors 
	};
	if(!isEmpty(errors))
		return x[@messages = errors];
    ids = uninitProgram(p);
	warnings = { warning("Variable <v> maybe uninitialized", l) | <loc l, PicoId v, STATEMENT s> <- ids };
	return x[@messages = warnings];
}

//  Define the connection with the QL evaluator

public void evalQLProgram(Program x, loc selection) 
{
	m = implode(#PROGRAM, x); 
	text(evalProgram(m));
}

//  Define connection with the QL compiler

public void compileQLProgram(Program x, loc l)
{
	p = implode(#PROGRAM, x);
    asm = compileProgram(p);
	text(asm);
}

//  Define connection with CFG visualization

public void visualizeQLProgram(Program x, loc selection) 
{
	m = implode(#Program, x); 
	CFG = cflowProgram(m);
	render(visCFG(CFG.graph));
}

//  Define all contributions to the QL IDE

public set[Contribution] QL_CONTRIBS = 
{
	popup(
		menu("QL",[
		    action("Evaluate QL program", evalQLProgram),
    		action("Compile QL to ASM", compileQLProgram),
    		action("Show Control flow graph", visualizeQLProgram)
		   	    ])
  		  )
};

//  Register the QL tools

public void registerQL() {
  registerLanguage(QL_NAME, QL_EXT, parser);
  registerAnnotator(QL_NAME, checkQLProgram);
  registerContributions(QL_NAME, QL_CONTRIBS);
}

public void main() 
{
	registerLanguage(LANG, EXT, Tree(str src, loc l) 
  {
     return parse(src, l);
  });
}