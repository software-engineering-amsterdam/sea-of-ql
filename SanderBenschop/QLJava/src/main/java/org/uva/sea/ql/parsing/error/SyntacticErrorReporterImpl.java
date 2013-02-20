package org.uva.sea.ql.parsing.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyntacticErrorReporterImpl {

    private final List<SyntacticQLError> syntacticQLErrors;

    public SyntacticErrorReporterImpl() {
        syntacticQLErrors = new ArrayList<SyntacticQLError>();
    }

    public void reportError(SyntacticQLError syntacticQLError) {
        syntacticQLErrors.add(syntacticQLError);
    }

    public List<SyntacticQLError> getErrors() {
        return Collections.unmodifiableList(syntacticQLErrors);
    }
}
