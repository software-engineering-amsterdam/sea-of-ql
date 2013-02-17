package org.uva.sea.ql.parser.error.reporting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.uva.sea.ql.parser.error.SyntacticQLError;

public class SimpleSyntacticErrorReporter implements SyntacticErrorReporter {

    private final List<SyntacticQLError> syntacticQLErrors;

    public SimpleSyntacticErrorReporter() {
        syntacticQLErrors = new ArrayList<SyntacticQLError>();
    }

    @Override
    public void reportError(SyntacticQLError syntacticQLError) {
        syntacticQLErrors.add(syntacticQLError);
    }

    @Override
    public boolean hasErrors() {
        return (!syntacticQLErrors.isEmpty());
    }

    @Override
    public List<SyntacticQLError> getErrors() {
        return Collections.unmodifiableList(syntacticQLErrors);
    }

    @Override
    public void clearErrors() {
        syntacticQLErrors.clear();
    }
}
