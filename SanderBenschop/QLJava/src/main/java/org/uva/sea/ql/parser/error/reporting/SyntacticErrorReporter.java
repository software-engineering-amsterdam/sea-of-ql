package org.uva.sea.ql.parser.error.reporting;

import java.util.List;

import org.uva.sea.ql.parser.error.SyntacticQLError;

public interface SyntacticErrorReporter {

    void reportError(SyntacticQLError syntacticQLError);

    boolean hasErrors();

    List<SyntacticQLError> getErrors();
}
