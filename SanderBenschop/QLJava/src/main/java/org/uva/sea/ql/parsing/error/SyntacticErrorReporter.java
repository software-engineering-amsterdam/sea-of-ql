package org.uva.sea.ql.parsing.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyntacticErrorReporter {

    private final List<SyntacticQLError> syntacticQLErrors;

    public SyntacticErrorReporter() {
        syntacticQLErrors = new ArrayList<SyntacticQLError>();
    }

    public void reportError(SyntacticQLError syntacticQLError) {
        syntacticQLErrors.add(syntacticQLError);
    }

    public List<SyntacticQLError> getErrors() {
        return Collections.unmodifiableList(syntacticQLErrors);
    }
}
