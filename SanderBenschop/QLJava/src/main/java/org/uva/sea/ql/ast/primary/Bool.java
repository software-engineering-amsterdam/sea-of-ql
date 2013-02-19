package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public final class Bool extends QLExpression {

    private final boolean value;

    public Bool(boolean value, SourceCodeInformation sourceCodeInformation) {
        super(sourceCodeInformation);
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new BooleanType();
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitBool(this);
    }
}
