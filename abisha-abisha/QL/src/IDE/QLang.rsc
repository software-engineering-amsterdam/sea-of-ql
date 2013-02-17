//Still working on this

module IDE::QLang

import Prelude;
import util::IDE;

import vis::Figure;
import vis::Render;

import syntax::abstractSyntax;
import syntax::ConcreteSyntax;
import TypeChecker::ExpressionChecker;
import TypeChecker::QuestionChecker;
import TypeChecker::Evaluate;
import Compiler::Compile;
import Visualization::ControlFlow;
import IDE::Uninit;
import Visualization::Visualize;

//language name and extension

private str QL_NAME = "QL";
private str QL_EXT = "ql";

//  Define the connection with the Pico parser
Tree parser(str x, loc l) 
{
    return parse(#Program, x, l);
}

//  Define connection with the Pico checkers
// (includes type checking and uninitialized variables check)

public Program checkPicoProgram(Program x) 
{
	p = implode(#PROGRAM, x);
	env = checkProgram(p);
	errors = 
	{
		error(v, l) | <loc l, QuestionireId v> <- env.errors 
	};
	if(!isEmpty(errors))
		return x[@messages = errors];
    ids = uninitProgram(p);
	warnings = 
	{
		warning("Variable <v> maybe uninitialized", l) | <loc l, QuestionireId v, STATEMENT s> <- ids 
	};
	return x[@messages = warnings];
}

//  Define the connection with the Pico evaluator

public void evalQLProgram(Program x, loc selection) 
{
	m = implode(#PROGRAM, x); 
	text(evalProgram(m));
}
//  Define connection with the Pico compiler
public void compileQlProgram(Program x, loc l)
{
    p = implode(#PROGRAM, x);
    asm = compileProgram(p);
	text(asm);
}

//  Define connection with CFG visualization

public void visualizeQLProgram(Program x, loc selection) 
{
	m = implode(#PROGRAM, x); 
	CFG = cflowProgram(m);
	render(visCFG(CFG.graph));
}

//  Define all contributions to the Pico IDE

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
//  Register the Pico tools
public void registerQL() 
{
  registerLanguage(QL_NAME, QL_EXT, parser);
  registerAnnotator(QL_NAME, checkQLProgram);
  registerContributions(QL_NAME, QL_CONTRIBS);
}