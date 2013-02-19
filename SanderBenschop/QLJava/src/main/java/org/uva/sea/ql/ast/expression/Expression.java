package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.general.SymbolTable;

public abstract class Expression implements Node {

    private final SourceCodeInformation sourceCodeInformation;

    public Expression(SourceCodeInformation sourceCodeInformation) {
        this.sourceCodeInformation = sourceCodeInformation;
    }

    public SourceCodeInformation getSourceCodeInformation() {
        return sourceCodeInformation;
    }

    public abstract Type getType(SymbolTable symbolTable);
}
