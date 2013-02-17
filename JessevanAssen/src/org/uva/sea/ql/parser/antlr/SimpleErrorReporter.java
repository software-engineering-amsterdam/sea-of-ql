package org.uva.sea.ql.parser.antlr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleErrorReporter implements ErrorReporter, Iterable<String> {

    private final List<String> errors;

    public SimpleErrorReporter() {
        this.errors = new ArrayList<String>();
    }

    @Override
    public void reportError(String error) {
        errors.add(error);
    }

    @Override
    public Iterator<String> iterator() {
        return errors.iterator();
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
