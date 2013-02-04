module lang::qls::ide::Check

import lang::ql::ast::AST;
import lang::ql::util::Environment;
import lang::qls::ast::AST;
import lang::qls::util::Environment;
import lang::qls::util::Implode;
import lang::qls::util::QL;
import util::IDE;
import ParseTree;
import Message;



public Contribution getQLSAnnotator() 
  = annotator(Tree (Tree input) {
	  return input[@messages=annotate(implode(input))];
    });
       
    
public set[Message] annotate(FormStyle style) {
	
	formQL = getForm(style.name);
	
	if (formQL := form("", []))
		return {error("No QL file with such name!", style@location)};
	else
		return getStyleEnvironment(style, formQL).messages;
}
