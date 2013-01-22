package org.uva.sea.ql.interpreter;

import java.io.IOException;
import java.io.PrintWriter;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;
import org.uva.sea.ql.visitor.VisitorException;

public class HTMLGen {
	private static final String OUT_PATH = "";
	
	public static void main(String[] args) {
		try {

			IParse parser = new ANTLRParser();
			Expr e = parser.parseDefaultFile();
			new Validator().validate(e);
			Form f = (Form) e;
			HTMLVisitor visitor = new HTMLVisitor();
			f.accept(visitor);
			String output = visitor.getOutput();
			PrintWriter out = new PrintWriter(OUT_PATH + f.getName() + ".html");		
			out.println(output);
			out.close();
			System.out.println(visitor.getOutput());

		} catch (IOException ex) {
			System.out.println("IO Exception: " + ex.getMessage());
		} catch (ParseError ex) {
			System.out.println("ParseError: " + ex.getMessage());
		} catch (AstValidationError ex) {
			System.out.println("AST Validation Error: " + ex.getMessage());
		} catch (VisitorException ex) {
			System.out.println("Visitor Error: " + ex.getMessage());
		}

	}
}