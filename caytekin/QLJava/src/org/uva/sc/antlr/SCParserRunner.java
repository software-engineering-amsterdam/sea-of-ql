package org.uva.sc.antlr;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class SCParserRunner {
	
	public static void printTree(CommonTree tree) {
		int noOfChildren = tree.getChildCount();
		System.out.println("This tree has: " + noOfChildren + " children.");		
		for (int i=0; i < noOfChildren; i++){
			System.out.print("Child "+ i + " is of type " + tree.getChild(i).getType());
			System.out.println(" and has text: " + tree.getChild(i).getText());			
		}
	}
	
	public static void main(String[] args) throws Exception {
		String filePar = "C:\\Users\\caytekin\\Downloads\\ANTLR\\sampleinput\\input1.txt";
        SimpleCalcLexer lex = new SimpleCalcLexer(new ANTLRFileStream(filePar));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        SimpleCalcParser parser = new SimpleCalcParser(tokens);
 
        try {
        	CommonTree ast = (CommonTree) parser.expr().getTree();
        	printTree(ast);
            System.out.println(parser.expr());
            System.out.println("I did it.");
        } 
        catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }

}
