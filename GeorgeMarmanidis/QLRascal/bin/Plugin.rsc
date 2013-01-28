@contributor{George Marmanidis -geo.marmani@gmail.com}
module Plugin

import util::IDE;
import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::SemanticCheck::SemanticCheck;
import lang::ql::IDE::Outline;
import lang::ql::ast::AST;
import ParseTree;

import Node;
import IO;

private str LANG = "QL-R";
private str EXT = "q";

public void compileQL(Tree x, loc selection) {
	
}

public void main() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });

 registerContributions(LANG, {
    	outliner(node (Tree t) {
			return outline(implode(t));
			}
		),
	
		menu(menu("QL",[
		    action("Generate JavaScript", compileQL)
	    ])
  	),
		
	annotator(Tree (Tree t) {
			return t[@messages = semanticCheck(implode(t))];
  		})
  	});
  	
  	
  	
  	
}
