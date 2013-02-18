package org.uva.sea.ql.parser.error.reporting;

import org.uva.sea.ql.parser.error.SyntacticQLError;

import java.util.List;

public interface SyntacticErrorReporter {

    void reportError(SyntacticQLError syntacticQLError);

    boolean hasErrors();

    List<SyntacticQLError> getErrors();

    void clearErrors();
}
