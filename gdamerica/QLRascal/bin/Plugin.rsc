/**
 * This module contains main function   
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module Plugin

import util::IDE;
import lang::ql::util::Parse;
import ParseTree;

private str LANG = "QLRascal";
private str EXT = "q";

public void main() {	
	registerLanguage(LANG, EXT, Tree(str src, loc l) {
   		return parse(src, l);
 	});
 	 
}
