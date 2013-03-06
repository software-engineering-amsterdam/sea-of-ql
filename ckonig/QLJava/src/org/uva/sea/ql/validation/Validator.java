package org.uva.sea.ql.validation;

import java.util.List;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.parser.ParseError;

public class Validator {
    private List<String> errors;

    public Validator() {
    }

    public final List<String> getErrors() {
        return this.errors;
    }

    public final boolean hasErrors() {
        return this.errors.size() > 0;
    }

    public final void validate(Form e) throws AstValidationError {
        try {
            if (e != null) {
                final Form f = (Form) e;
                final ValidationElementVisitor validator = new ValidationElementVisitor();
                f.accept(validator);
                this.errors = validator.getErrors();
            } else {
                throw new AstValidationError("result was null");
            }
        } catch (ParseError ex) {
            throw new AstValidationError(ex.getMessage());
        } catch (QLException ex) {
            throw new AstValidationError(ex.getMessage());
        }
    }
}
