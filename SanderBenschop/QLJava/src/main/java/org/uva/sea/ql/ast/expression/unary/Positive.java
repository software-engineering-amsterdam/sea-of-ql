package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public class Positive extends UnaryOperation {

    public Positive(Expression expression, SourceCodeInformation sourceInfo) {
        super(expression, sourceInfo);
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new IntegerType();
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitPositive(this);
    }
}
