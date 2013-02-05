package org.uva.sea.ql.validation;

import java.io.IOException;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ASTVisitor;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.parser.ParseError;

public class Validator {
    public Validator() {

    }

    public final void validate(Expr e) throws IOException, AstValidationError {
        try {
            if (e != null) {
                if (e.getClass().equals(Form.class)) {
                    final Form f = (Form) e;
                    final ASTVisitor validator = new ValidationVisitor();
                    f.accept(validator);
                    System.out.println("validation success");
                } else {
                    throw new AstValidationError("root element must be form");
                }
            } else {
                throw new AstValidationError("result was null");
            }
        } catch (ParseError ex) {
            System.out.println("ParseError: " + ex.getMessage());
        } catch (VisitorException ex) {
            System.out.println("Visitor Error: " + ex.getMessage());
        }

    }
}
