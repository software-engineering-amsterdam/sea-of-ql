package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.SourceCodeInformation;

public abstract class QLError {

    private final SourceCodeInformation sourceCodeInformation;

    public QLError(SourceCodeInformation sourceCodeInformation) {
        this.sourceCodeInformation = sourceCodeInformation;
    }

    protected SourceCodeInformation getSourceCodeInformation() {
        return sourceCodeInformation;
    }

    public abstract String getErrorMessage();
}
