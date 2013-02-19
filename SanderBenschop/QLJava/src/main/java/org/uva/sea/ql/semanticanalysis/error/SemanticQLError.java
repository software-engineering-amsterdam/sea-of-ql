package org.uva.sea.ql.semanticanalysis.error;

import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.QLError;

public abstract class SemanticQLError implements QLError {

    private final SourceCodeInformation sourceCodeInformation;

    public SemanticQLError(SourceCodeInformation sourceCodeInformation) {
        this.sourceCodeInformation = sourceCodeInformation;
    }

    protected SourceCodeInformation getSourceCodeInformation() {
        return sourceCodeInformation;
    }
}
