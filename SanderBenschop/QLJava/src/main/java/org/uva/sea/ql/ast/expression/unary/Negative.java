package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.SymbolTableImpl;

public final class Negative extends UnaryOperation {

    public Negative(Expression expression, SourceCodeInformation sourceCodeInformation) {
        super(expression, sourceCodeInformation);
    }

    @Override
    public Type getType(SymbolTableImpl symbolTable) {
        return new IntegerType();
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitNegative(this);
    }
}
