/* Questionire laanguage IDE
author @abisha
*/
module IDE::ide

import Prelude;
import vis::Figure;
import vis::Render;

import syntax::Abstract;
import syntax::Concrete;
import TypeCheck::QuestionChecker;
import Visualization::ControlFlow;
import Visualization::Visualize;
import IDE::Uninit;
import util::IDE;
import util::ValueUI;
import load::Parse;
import load::Implode;
import ParseTree;

//Name and file Extension
private str QL_NAME = "QL";
private str QL_EXT = "ql";

//Define the connection with the QL parser
public Tree parser(str x, loc l) 
{
    return parseForm(x,l);
}

//  Define connection with the QL TypeChecker
public Form checkQLForm(Form x) 
{
	p = implodeForm(#Form, x);
	env = checkForm(p);
	errors = 
	{
		error(v, l) | <loc l, PicoId v> <- env.errors 
	};
	if(!isEmpty(errors))
		return x[@messages = errors];
    ids = uninitForm(p);
	warnings = 
	{
		warning("Variable <v> maybe uninitialized", l) | <loc l, PicoId v, STATEMENT s> <- ids 
	};
	return x[@messages = warnings];
}

//  Define the connection with the QL evaluator
public void evalQLForm(Tree x, loc selection) 
{
	m = implode(#Form, x); 
	text(evalForm(m));
}

//  Define connection with CFG visualization
public void visualizeQLForm(Tree x, loc selection) 
{
	m = implode(#Form, x); 
	CFG = cflowForm(m);
	render(visCFG(CFG.graph));
}

//generate the IDE
public void generateQLForm(Tree x, loc selection) 
{	
	generateQLForm(implodeForm(x));
}

//  Define all contributions to the QL IDE
public set[Contribution] QL_CONTRIBS = 
{
	popup(
		menu("QL",[
					action("Evaluate QL Form", evalQLForm),
					action("Generate QL Form", generateQLForm),
		     		action("Show Control flow graph", visualizeQLForm)
	    		])
  		)
};

//  Register the QL IDE
public void registerQL() 
{
	println("in main");
  	registerLanguage(QL_NAME, QL_EXT, parser); 
  	registerContributions(QL_NAME, QL_CONTRIBS);
}
