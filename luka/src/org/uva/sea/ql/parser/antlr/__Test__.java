package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;

public class __Test__ {

	public static void main(String args[]) throws Exception {
		QLLexer lex = new QLLexer(
				new ANTLRFileStream(
						"/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/__Test___input.txt",
						"UTF8"));
		
		CommonTokenStream tokens = new CommonTokenStream(lex);
		QLParser parser = new QLParser(tokens,49100,null); 
		
		
		
		try {
		CommonTree tree = 	 (CommonTree) parser.parse().getTree();
	
		//	Questionnaire questionnaire =	
		//	System.out.println(questionnaire.getName());
			
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
}