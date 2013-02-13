module Plugin

import IO;
import Set;
import String;
import Message;
import ParseTree;

import util::IDE;
import util::Prompt;

import lang::ql::util::Parse;
import lang::ql::util::Implode;

import lang::ql::ast::AST;
import lang::ql::ast::Outline;

import lang::ql::checker::CheckQuestions;
import lang::ql::checker::CheckExpressions;

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
			Form form = implode(t);
			return t[@messages = checkQuestions(form) + checkExpressions(form)];
  		}),
  		popup(
			menu(LANG, [
	    		action("Java generator", void (Tree t, loc l) {
					Form form = implode(t);					
					set[Message] messages = checkQuestions(form) + checkExpressions(form);
					
					if ({S1*, error(_, _), S2*} := messages) {
						alert("Cannot build Java file: the QL form contains errors!");
					}
					else {
						str name = toUpperCase(substring(form.name, 0, 1)) + substring(form.name, 1);
				  		loc output = |project://QLRascal/output/<name>.java|;	
				  					  	
				  		writeFile(output, generateJava(form, name));
					}			
	    		})
		    ])
	  	)
	});
}
