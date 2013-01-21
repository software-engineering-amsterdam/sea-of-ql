package org.uva.sea.ql.parser.antlr;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.TreeParser;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.IfBlock;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.QuestionnaireContent;
import org.uva.sea.ql.ast.QuestionnaireForm;
import org.uva.sea.ql.ast.QuestionnaireItemInterface;
import org.uva.sea.ql.parser.test.ParseError;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;


public class ParserExecute {

	public static void main(String[] args) throws ParseError {
		String src ="a || b";
		boolean file = true;
		if(file){
			try {
				src = loadFileToString("/Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/__Test___input.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		
		//TreeParser tp = new TreeParser();
		
		QLParser parser = new QLParser(tokens);
		
		try {
			parser.parse();
//			System.out.println("Parsing" );
//			QuestionnaireForm root = (QuestionnaireForm) parser.parse();
//			System.out.println("root: " + root.getFormName());
//			QuestionnaireContent content= root.getContent();
//			List<QuestionnaireItemInterface> items = content.getAllQuestionnaireItems();
//			System.out.println("QuestionnaireItems: " + items.size());
//			for (QuestionnaireItemInterface item : items) {
//				if(item.getClass() == Question.class){
//					System.out.println("Question: " + ((Question)item).getQuestionLabel());
//				}else{
//					IfBlock ifBlock = (IfBlock)item;
//					System.out.println("IfBlock items: "+ifBlock.getIfBlockItems().size());
//					System.out.println("IfBlock Condition: "+ifBlock.getcExprString());
//					for (QuestionnaireItemInterface ifBlockItem : ifBlock.getIfBlockItems()) {
//						System.out.println("If question label: "+((Question)ifBlockItem).getQuestionLabel());
//					}
//				}
//				
//			}
		} 
		catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
		/*
		 * try { CharStream input = new ANTLRFileStream(args[0]); XMLLexer lexer
		 * = new XMLLexer(input); Token token; while ((token =
		 * lexer.nextToken())!=Token.EOF_TOKEN) {
		 * System.out.println("Token: "+token.getText()); } } catch(Throwable t)
		 * { System.out.println("Exception: "+t); t.printStackTrace(); }
		 */
	}

	private static String loadFileToString(String fileName) throws IOException {
		File file = new File(fileName);
		StringBuffer content = new StringBuffer();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String s = null;

			while ((s = reader.readLine()) != null) {
				content.append(s).append(System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				throw e;
			}
		}
		return content.toString();
	}

}
