module Plugin

import IO;
import String;
import ParseTree;
import util::IDE;

import lang::ql::util::Parse;
import lang::ql::util::Implode;

import lang::ql::ast::AST;
import lang::ql::ast::Outline;
import lang::ql::checker::Check;
import lang::ql::generator::GenerateJava;

private str LANG = "QL-R";
private str EXT = "q";

public void main() {	
	registerLanguage(LANG, EXT, Tree(str src, loc l) {
   		return parse(src, l);
 	});
 	 
  	registerContributions(LANG, {
    	outliner(node (Tree t) {
			return outline(implode(t));
		}),
		annotator(Tree (Tree t) {
			return t[@messages = checkForm(implode(t))];
  		}),
  		popup(
			menu(LANG, [
	    		action("Java generator", void (Tree t, loc l) {;
					Form form = implode(t);
					
					str name = toUpperCase(substring(form.name, 0, 1)) + substring(form.name, 1);
				  	loc output = |project://QLRascal/output/<name>.java|;	
				  				  	
				  	writeFile(output, generateJava(form, name));
	    		})
		    ])
	  	)
	});
}
