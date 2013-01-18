package org.uva.sea.ql.parser.antlr;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.runtime.*;
import org.uva.sea.ql.parser.test.ParseError;


public class ParserExecute {

	public static void main(String[] args) throws ParseError {
		String src ="a || b";
		boolean file = true;
		if(file){
			try {
				src = loadFileToString("/Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/questionnaire.ql");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		// ------
//		 CommonTree tree = (CommonTree)parser.parse().getTree();
//		    DOTTreeGenerator gen = new DOTTreeGenerator();
//		    ST st;
//		    //StringTemplate st = gen.toDOT(tree);
//		    System.out.println(st);
//		
		
		//---

		try {
			
			System.out.println("Parsing:" );//orExpr()); //
			parser.parse();
			// return parser.orExpr();
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
