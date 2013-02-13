package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;
import org.uva.sea.ql.ast.stat.Stat;
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
			    Block questionnaireBlock = returned.getBlock();
			    System.out.println("------------------- starting loop"); 
			    for(Stat qStat : questionnaireBlock.getStatements()){
			    //printDebug("--outer loop","starting");
			    	if(qStat instanceof AnswerableStat){
			    		printDebug("AnswerableStat:","--->");
			    		AnswerableStat answerableStat = (AnswerableStat) qStat;
			    		printDebug("label",answerableStat.getLabel());
			    		printDebug("type",answerableStat.getType().toString());
			    		printDebug("ident",answerableStat.getIdent().toString());
			    		printDebug("AnswerableStat:","<---");
			    	}else if(qStat instanceof IfThenStat){
			    		
			    	}else if(qStat instanceof IfThenElseStat){
			    		
			    	}
			    	//System.out.println(qStat.toString());
			    }
			  
			}
			
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
	private static void printDebug(String from, String stuff){
		System.out.println(from+" : "+stuff);
	}
}