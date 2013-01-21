package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class ValidationRunner {
	private static final String defaultSrc = "C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\example.ql";

	public static void main(String args[]) throws Exception {
		Validator v = new Validator();
		try {
			IParse parser = new ANTLRParser();
			Expr e = parser.parseFile(defaultSrc);
			v.validate(e);
		} catch (ParseError ex) {
			ex.printStackTrace();
		} catch (AstValidationError ex) {
			ex.printStackTrace();
		}
		System.out.println("validation finished");
	}
}
