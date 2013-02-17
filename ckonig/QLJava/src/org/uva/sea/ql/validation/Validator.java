package org.uva.sea.ql.validation;

import java.util.List;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.parser.ParseError;

public class Validator {
    private boolean throwExceptions;
    private List<String> errors;
    public Validator() {
        this.throwExceptions = false;
    }

    public Validator(boolean throwErrors) {
        this();
        this.throwExceptions = throwErrors;
    }
    
    public List<String> getErrors(){
        return this.errors;
    }
    public boolean hasErrors(){
        return this.errors.size() > 0;
    }
    public final void validate(Form e) throws AstValidationError {
        try {
            if (e != null) {
                final Form f = (Form) e;
                final ValidationVisitor validator = new ValidationVisitor(
                        this.throwExceptions);
                f.accept(validator);
                System.out.println("validation success");
                this.errors = validator.getErrors();
            } else {
                throw new AstValidationError("result was null");
            }
        } catch (ParseError ex) {
            System.out.println("ParseError: " + ex.getMessage());
        } catch (QLException e1) {
            throw new AstValidationError(e1.getMessage());
        }
    }
}
