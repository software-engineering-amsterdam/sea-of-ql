package org.uva.sea.ql.validation;

import java.io.IOException;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Validator {
	public void validate(Expr e) throws IOException, AstValidationError {
		if (e != null) {
			if (e.getClass().equals(Form.class)) {
				Form f = (Form) e;
				ASTVisitor validator = new ValidationVisitor();
				f.accept(validator);
				System.out.println("validation success");
			} else {
				throw new AstValidationError("root element must be form");
			}
		} else {
			throw new AstValidationError("result was null");
		}

	}
}
