package org.uva.sea.ql.parser.error.reporting;

import org.uva.sea.ql.parser.error.SyntacticQLError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyntacticErrorReporterImpl implements SyntacticErrorReporter {

    private final List<SyntacticQLError> syntacticQLErrors;

    public SyntacticErrorReporterImpl() {
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
