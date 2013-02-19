package org.uva.sea.ql.ast.expression.primary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public final class Int extends Expression {

    private final int value;

    public Int(int value, SourceCodeInformation sourceCodeInformation) {
        super(sourceCodeInformation);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new IntegerType();
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitInt(this);
    }
}
