package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.uva.sea.ql.questionnaire.Questionnaire;


public class __Test__ {

	public static void main(String args[]) throws Exception {
		QLLexer lex = new QLLexer(
				new ANTLRFileStream(
						"/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/__Test___input.txt",
						"UTF8"));
		
		CommonTokenStream tokens = new CommonTokenStream(lex);
		boolean onlyParse = false;
		QLParser parser = new QLParser(tokens); // new QLParser(tokens,49100,null); //
		
		
		try {
			if(onlyParse){
				parser.parse();
			}else{
				CommonTree tree = (CommonTree)parser.parse().getTree();  
			    CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);  
			    QLTreeWalker walker = new QLTreeWalker(nodes, parser.typeEnv);  
			    // get the returned node   
			    Questionnaire returned = walker.walk();
			    System.out.println(returned.toString()); 
			}
			
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
}