package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.parser.ParseError;

public class Validator {
    public Validator() {

    }

    public final void validate(Form e) throws AstValidationError {
        try {
            if (e != null) {
                final Form f = (Form) e;
                final ElementVisitor validator = new ValidationVisitor();
                f.accept(validator);
                System.out.println("validation success");

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
