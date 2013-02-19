package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public abstract class Expression implements ASTNode {

    private final SourceCodeInformation sourceCodeInformation;

    public Expression(SourceCodeInformation sourceCodeInformation) {
        this.sourceCodeInformation = sourceCodeInformation;
    }

    public SourceCodeInformation getSourceCodeInformation() {
        return sourceCodeInformation;
    }

    public abstract Type getType(SymbolTable symbolTable);
}
