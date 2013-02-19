package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public abstract class QLExpression implements ASTNode {

    private final SourceCodeInformation sourceCodeInformation;

    public QLExpression(SourceCodeInformation sourceCodeInformation) {
        this.sourceCodeInformation = sourceCodeInformation;
    }

    public SourceCodeInformation getSourceCodeInformation() {
        return sourceCodeInformation;
    }

    public abstract Type getType(SymbolTable symbolTable);
}
