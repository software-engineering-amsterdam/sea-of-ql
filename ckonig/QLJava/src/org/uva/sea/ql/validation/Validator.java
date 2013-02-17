package org.uva.sea.ql.validation;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.interfaces.ElementVisitor;
import org.uva.sea.ql.parser.ParseError;

public class Validator {
    private boolean throwExceptions;
    private List<String> errors;
    public Validator() {
        this.throwExceptions = false;
        this.errors = new ArrayList<String>();
    }
    public Validator(boolean throwErrors){
        this();
        this.throwExceptions = throwErrors;
    }
    
    public boolean hasErrors(){
        return this.errors.size() > 0;
    }
    public List<String> getErrors(){
        return this.errors;
    }

    public final void validate(Form e) throws AstValidationError {
        try {
            if (e != null) {
                final Form f = (Form) e;
                final ElementVisitor validator = new ValidationVisitor(this.throwExceptions);
                f.accept(validator);
                System.out.println("validation success");
            } else {
                throw new AstValidationError("result was null");
            }
        } catch (ParseError ex) {
            System.out.println("ParseError: " + ex.getMessage());
        } catch (QLException e1) {
            if(throwExceptions){
                throw new AstValidationError(e1.getMessage());
            }else{
                this.errors.add(e1.getMessage());
            }
        } 
    }
}
