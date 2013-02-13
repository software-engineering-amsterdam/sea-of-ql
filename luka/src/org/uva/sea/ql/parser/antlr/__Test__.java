package org.uva.sea.ql.parser.antlr;

import java.util.List;

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
		QLParser parser = new QLParser(tokens,49100,null); //new QLParser(tokens); //   // //  new QLParser(tokens,49100,null); //
		
		//privateDebt3: "Private debts for the sold house:" money
		try {
			if(onlyParse){
				parser.parse();
			}else{
				CommonTree tree = (CommonTree)parser.parse().getTree();  
			    CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);  
			  //  QLTreeWalker walker = new QLTreeWalker(nodes, parser.typeEnv);   parser.getDebugListener()
//			    QLTreeWalker walker = new QLTreeWalker(nodes, parser.typeEnv);   
			    QLTreeWalker walker = new QLTreeWalker(nodes, parser.typeEnv);//49100,null); //   
			    // get the returned node   
			    Questionnaire returned = walker.walk();
			    Block questionnaireBlock = returned.getBlock();
			    System.out.println("------------------- starting loop"); 
			    recursivePrint(questionnaireBlock.getStatements());
			  
			}
			
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
	
	private static void recursivePrint(List<Stat> stats){
		//System.err.println("Entering ---");
		for(Stat qStat : stats){
		    //printDebug("--outer loop","starting");
		    	if(qStat instanceof AnswerableStat){
//		    		printDebug("Answer:","--->");
//		    		AnswerableStat answerableStat = (AnswerableStat) qStat;
//		    		printDebug("label",answerableStat.getLabel());
//		    		printDebug("type",answerableStat.getType().toString());
//		    		printDebug("ident",answerableStat.getIdent().toString());
//		    		printDebug("Answer:","<---");
		    	}else if(qStat instanceof IfThenStat){
		    		IfThenStat ifThen = (IfThenStat) qStat;
//		    		printDebug("If:","--->");
		    		printDebug("expr: ",ifThen.getExpr().toString());
//		    		printDebug("body:",ifThen.getBody().getStatements().size()+"");
//		    		printDebug("If:","<---");
		    		recursivePrint(ifThen.getBody().getStatements());
		    	}else if(qStat instanceof IfThenElseStat){
		    		IfThenElseStat ifThenElse = (IfThenElseStat) qStat;
//		    		printDebug("IfElse:","--->");
		    		printDebug("expr:",ifThenElse.getExpr().toString());
//		    		printDebug("body:",ifThenElse.getBody().getStatements().size()+"");
//		    		printDebug("IfBlock:","->");
		    		recursivePrint(ifThenElse.getBody().getStatements());
//		    		printDebug("IfBlock:","<-");
//		    		printDebug("IfBlock:","->");
		    		recursivePrint(ifThenElse.getElseBody().getStatements());
//		    		printDebug("IfBlock:","<-");
//		    		printDebug("IfElse:","<---");
		    	}
		    	//System.out.println(qStat.toString());
		    }
	}
	private static void printDebug(String from, String stuff){
		System.out.println(from+" : "+stuff);
	}
}