package org.uva.sea.ql.parsing.error.reporting;

import org.uva.sea.ql.parsing.error.SyntacticQLError;

import java.util.List;

public interface SyntacticErrorReporter {

    void reportError(SyntacticQLError syntacticQLError);

    boolean hasErrors();

    List<SyntacticQLError> getErrors();
}
