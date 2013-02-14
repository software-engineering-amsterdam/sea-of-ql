package org.uva.sea.ql.parser.antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedStat;
import org.uva.sea.ql.ast.stat.ConditionalStat;
import org.uva.sea.ql.ast.stat.HiddenComputetStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.stat.VisibleComputetStat;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.CheckExpr;
import org.uva.sea.ql.ast.visitor.CheckStat;
import org.uva.sea.ql.questionnaire.Questionnaire;
import org.uva.sea.ql.questionnaire.QuestionnaireProcessor;


public class __Test__ {

	public static void main(String args[]) throws Exception {
		QLLexer lex = new QLLexer(
				new ANTLRFileStream(
						"/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/__Test___input.txt",
						"UTF8"));
		
		CommonTokenStream tokens = new CommonTokenStream(lex);
		boolean onlyParse = false;
		QLParser parser =new QLParser(tokens); //  new QLParser(tokens,49100,null); //  // //  new QLParser(tokens,49100,null); //
		
		//
		try {
			if(onlyParse){
				parser.parse();
			}else{
				CommonTree tree = (CommonTree)parser.parse().getTree();  
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);  
			    QLTreeWalker walker = new QLTreeWalker(nodes);// 49100,null); //   

			    
			    Questionnaire questionnaire = walker.walk();
			
			    Map<Ident,Type> typeEnv = parser.typeEnv;
			    
			    QuestionnaireProcessor processor = new QuestionnaireProcessor(questionnaire, typeEnv);
			    processor.process();
//			    Block questionnaireStatementsBlock = questionnaire.getBlock();
			  //  List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
			//    CheckStat.checkStatBlock(questionnaireStatementsBlock, typeEnv, errorList);
			//    printErrorList(errorList);
//			    List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
			    
//			    for(Stat s : questionnaireStatementsBlock.getStatements()){
//			    	
//			    	if(s instanceof ComputedStat){
//			    		Expr statementExpr = ((ComputedStat) s).getExpr();
//			    		System.out.println("ComputedStat:"+ ((ComputedStat) s).getLabel());
//			    		Boolean check = CheckExpr.check(statementExpr, typeEnv, errorList);
//			    		System.out.println("check:"+check.toString());
//			    	}else if(s instanceof AnswerableStat){
//			    		//System.out.println("AnswerableStat:"+ ((AnswerableStat) s).getLabel());
//			    	}else if(s instanceof ConditionalStat){
//			    		Expr statementExpr = ((ConditionalStat) s).getExpr();
//			    		System.out.println("ConditionalStat:"+statementExpr.toString());
//			    		Boolean check = CheckExpr.check(statementExpr, typeEnv, errorList);
//			    		System.out.println("check:"+check.toString());
//			    	}
//			    }
			    
				//
			  
			}
			
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void recursivePrint(List<Stat> stats){
		 System.out.println("------------------- starting loop"); 
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