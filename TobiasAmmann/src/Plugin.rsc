module Plugin

import Prelude;
import ParseTree;
import util::IDE;

import lang::ql::util::Parse;
import lang::ql::syntax::Syntax;
import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::IDE::Outline;
import lang::ql::util::Typecheck;
import lang::ql::Generator::htmlGenerator;
import lang::ql::Generator::jQueryGenerator;

private str LANG = "QL-R";
private str EXT = "ql";


public void main() {

  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });
  
  registerContributions(LANG, {
  	outliner(node (Tree t) {
  		return qlOutliner(implode(t)); 
  	}),
  	annotator(Tree (Tree t){
  		return t[@messages = check(implode(t))];
  	}),
  	popup(
			menu(LANG, [
	    		action("compile to HTML-Javascript", void (Tree t, loc l) {
					FORM ast = implode(t);					
					set[Message] messages = check(ast);
					
					if ({S1*, error(_, _), S2*} := messages) {
						alert("Cannot compile file: the QL form contains errors!");
					}
					else {
						str name = toUpperCase(substring(ast.formName, 0, 1)) + substring(ast.formName, 1);
				  		loc output = |project://QLRascal/output/<name>.html|;	
				  		str file = (htmlGenerator(ast) + generateJQuery(ast));
				  					  	
				  		writeFile(output, file);
					}			
	    		})
		    ])
	  	)
   });
}

Tree parser(str x, loc l) {
    return parse(#FORM, x, l);
    }