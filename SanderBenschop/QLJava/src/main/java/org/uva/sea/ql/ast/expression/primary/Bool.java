package org.uva.sea.ql.ast.expression.primary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.SymbolTable;

public final class Bool extends Expression {

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
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitBool(this);
    }
}
