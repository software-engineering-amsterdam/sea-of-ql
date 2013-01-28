package org.uva.sea.ql.generator.html;

import java.io.IOException;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.interpreter.IOHelper;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;
import org.uva.sea.ql.visitor.VisitorException;

public class HTMLRunner {
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
			IOHelper.write(OUT_PATH + f.getName() + ".html", output);
			System.out.println(output);

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
