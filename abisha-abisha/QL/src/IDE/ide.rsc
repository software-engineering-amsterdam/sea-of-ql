//IDE still under construction

module IDE::ide


import Prelude;
import util::IDE;

import vis::Figure;
import vis::Render;

import syntax::Abstract;
import syntax::Concrete;
import TypeCheck::CheckExpression;
import TypeCheck::QuestionChecker;
import TypeCheck::EvaluateExpressions;
import Visualization::ControlFlow;
import IDE::Uninit;
import Visualization::Visualize;

//language name and extension

private str QL_NAME = "QL";
private str QL_EXT = "ql";

private str LANG = "QL-R";
private str EXT = "q";

//  Define the connection with the QL parser
Tree parser(str x, loc l) 
{
    return parseForm(x,l);
}

//  Define connection with the QL checkers
// (includes type checking and uninitialized variables check)
public Form checkQLForm(Form x) 
{
	p = implodeForm(#Form, x);
	env = checkForm(p);
	errors = 
	{
		error(v, l) | <loc l, QuestionId v> <- env.errors 
	};
	if(!isEmpty(errors))
		return x[@messages = errors];
    ids = uninitForm(p);
	warnings = 
	{
		warning("Variable <v> maybe uninitialized", l) | <loc l, QuestionId v, STATEMENT s> <- ids 
	};
	return x[@messages = warnings];
}

//  Define the connection with the QL evaluator
public void evalQLForm(Form x, loc selection) 
{
	m = implode(#Form, x); 
	text(evalForm(m));
}
//  generate the QL code from a file
public void generateQL(Tree x, loc selection) {
	println("tree : <x>");
	generateQLForm(implodeProgram(x));
}

//  Define connection with CFG visualization
public void visualizeQLForm(Form x, loc selection) 
{
	m = implode(#Form, x); 
	CFG = cflowForm(m);
	render(visCFG(CFG.graph));
}

//  Define all contributions to the QL IDE

public set[Contribution] QL_CONTRIBS = 
{
	popup(
		menu("QL",[
				//action("Compile QL Program", generateQL),*****
		     		action("Show Control flow graph", visualizeQLProgram)
	    		])
  		)
};
//  Register the QL tools
public void registerQL() 
{
  registerLanguage(QL_NAME, QL_EXT, parser);
  //registerContributions(QL_NAME, QL_CONTRIBS);
}