module IDE::ide

import Prelude;
import vis::Figure;
import vis::Render;
import syntax::Abstract;
import syntax::Concrete;
import TypeCheck::QuestionChecker;
import IDE::Outline;
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
public Form checkQForm(Form x) 
{
println("now checking the form");
	p = implodeForm(#Form, x);
	env = checkForm(p);
	errors = 
	{
		error(v, l) | <loc l, PicoId v> <- env.errors 
	};
	if(!isEmpty(errors))
		return x[@messages = errors];
		ids=uninitForm(p);
    warnings = 
	{
		warning("Variable <v> maybe uninitialized", l) | <loc l, PicoId v, STATEMENT s> <- ids 
	};
	return x[@messages = warnings];
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
	outliner(node(Tree t)
		{
			return outline(implodeForm(t));
		}
  	),
	menu(
		menu("QL",[
			action("Generate QL Form", generateQLForm),
			action("Show Control flow graph", visualizeQLForm)
	    		])
  			),
  	annotator(Tree (Tree t) 
  		{
			
			return t[@messages = checkQLForm(implodeForm(t))];
  		})
};
//  Register the QL IDE
public void registerQL() 
{
  	registerLanguage(QL_NAME, QL_EXT, parser); 
  	registerContributions(QL_NAME, QL_CONTRIBS);
}
