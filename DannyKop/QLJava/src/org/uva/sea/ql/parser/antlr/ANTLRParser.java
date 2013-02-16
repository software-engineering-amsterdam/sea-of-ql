package org.uva.sea.ql.parser.antlr;


import java.nio.file.FileSystems;
import java.nio.file.Files;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.parser.test.*;
import org.uva.sea.ql.visitor.messages.Message;
import org.uva.sea.ql.visitorTypeChecking.SemanticVisitor;


public class ANTLRParser implements IParse {

	@Override
	public ASTNode parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			Form f = parser.form();
			if(parser.isErrorFound()){
				throw new ParseError(parser.getErrors().toString());
			}
			return f;
			
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} 
	}
	public static void main(String[] args){
		ANTLRParser parser = new ANTLRParser();

		try {				
			String str;
			
			str = new String(Files.readAllBytes(FileSystems.getDefault().getPath("testfiles", "schoolExample.ql")));	
			System.out.println(str);
			
			ASTNode node = parser.parse(str);
			SemanticVisitor sv = new SemanticVisitor();
			node.accept(sv);
			if(sv.hasErrors()){
				for(Message m : sv.getErrors()){
					System.out.println(m.getMessage());
				}
			}			
		}catch(ParseError pe){
			System.out.println("Probleem met parsen: " + pe.getMessage());	
		}catch(Exception exc){
			exc.printStackTrace();
		}
   
	}
}
