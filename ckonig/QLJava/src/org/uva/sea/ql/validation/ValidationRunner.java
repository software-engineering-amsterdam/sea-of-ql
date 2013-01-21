package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.VisitorException;

public class ValidationRunner {

	public static void main(String args[]) throws Exception {
		Validator v = new Validator();
		try {
			IParse parser = new ANTLRParser();
			Expr e = parser.parseDefaultFile();
			v.validate(e);
		} catch (VisitorException ex) {
			ex.printStackTrace();
		}
		System.out.println("validation finished");
	}
}
