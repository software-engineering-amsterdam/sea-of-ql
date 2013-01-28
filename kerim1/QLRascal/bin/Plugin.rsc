module Plugin

import IO;
import ParseTree;
import util::IDE;
import util::Prompt;

import lang::ql::syntax::QL;
import lang::ql::ast::Check;
import lang::ql::ast::Outline;
import lang::ql::util::Parse;
import lang::ql::util::Implode;
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
	    		action("Java generator", void (Tree t, loc l) {
					str name = prompt("Name: ");
				  	loc output = |project://QLRascal/output/<name>.java|;
				  	writeFile(output, generateJava(implode(t)));
	    		})
		    ])
	  	)
	});
}
