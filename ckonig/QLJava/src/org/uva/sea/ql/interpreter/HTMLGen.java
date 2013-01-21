package org.uva.sea.ql.interpreter;

import java.io.IOException;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;

public class HTMLGen {
	private static final String defaultSrc = "C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\example.ql";

	public static void main(String[] args) {
		try {

			IParse parser = new ANTLRParser();
			Expr e = parser.parseFile(defaultSrc);
			new Validator().validate(e);
			Form f = (Form) e;
			HTMLVisitor visitor = new HTMLVisitor();
			f.accept(visitor);
			System.out.println(visitor.getOutput());

		} catch (IOException ex) {
			System.out.println("IO Exception: " + ex.getMessage());
		} catch (ParseError ex) {
			System.out.println("ParseError: " + ex.getMessage());
		} catch (AstValidationError ex) {
			System.out.println("AST Validation Error: " + ex.getMessage());
		}

	}
}
