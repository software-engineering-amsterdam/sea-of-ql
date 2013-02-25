package org.uva.sea.ql.validation;

import java.util.ArrayList;
import java.util.List;

public class AbstractValidationVisitor {

    protected final List<String> errors;

    protected final ValidationRegistry registry;

    public AbstractValidationVisitor(ValidationRegistry reg) {
        this.registry = reg;
        this.errors = new ArrayList<String>();
    }

    public final List<String> getErrors() {
        return this.errors;
    }

    public final boolean hasErrors() {
        return this.errors.size() > 0;
    }
}
