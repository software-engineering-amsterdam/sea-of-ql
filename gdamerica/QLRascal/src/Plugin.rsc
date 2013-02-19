/**
 * This module contains main function
 * and regeister function that register the QL languague extension "q" and a parser for use in Eclipse   
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module Plugin

import lang::ql::ide::SemanticChecker::FormChecker;
import lang::ql::ide::JavaGenerator::Generator;
import lang::ql::ide::Outline::Generator;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import lang::ql::ast::AST;
import util::Prompt;
import ParseTree;
import util::IDE;
import Set;
import IO;


private str LANG = "QL-R";
private str EXT = "q";

/**
* Set of contributions to be used in registerContributions
* contains outline, annotator and menu action contributions
*/
public set[Contribution] contribs = {
 		annotator(Tree (Tree t){
 			return t[@messages = checkQl(implode(t))];
 		}),
 		outliner(node (Tree t) {
			return genOutline(implode(t));
			}
		),
			popup(
			menu(LANG, [
	    		action("Generate a Java File", void (Tree t, loc l) {
	    				Form form = implode(t);	
	    				set[Message] messages = checkQl(form);
					
					if (!isEmpty(messages))
						alert("Cannot generate Java file: Syntax error(s) found in QL Form");
					else			  	
				  		writeFile(|project://QLRascal/JavaOutput/<form.fIdent>.java|, genJavaFile(implode(t)));
				  					
	    		})
		    ])
	  	)	
 	};

public void main() {	
	registerLanguage(LANG, EXT, Tree(str src, loc l) {
   		return parseForm(src, l);
 	});
	registerContributions(LANG, contribs);
 	 
}
