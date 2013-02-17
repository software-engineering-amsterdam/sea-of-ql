/**
 * This module contains main function
 * and regeister function that register the QL languague extension "q" and a parser for use in Eclipse   
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module Plugin

import util::IDE;
import lang::ql::util::Parse;
import lang::ql::util::Implode;
import ParseTree;
import lang::ql::ide::SemanticChecker::FormChecker;

private str LANG = "QL-R";
private str EXT = "q";
public set[Contribution] contribs = {
 		annotator(Tree (Tree t){
 			return t[@messages = checkQl(implode(t))];
 		})	
 	};
/**
* Main fucntion 
* Define all contributions to the QL IDE
* Register all the QL language tools(Outline, semanticChecker)
*/
public void main() {	
	registerLanguage(LANG, EXT, Tree(str src, loc l) {
   		return parseForm(src, l);
 	});
	registerContributions(LANG, contribs);
 	 
}
