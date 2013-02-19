package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.SymbolTable;

public final class EqualTo extends BinaryOperation {

    public EqualTo(Expression leftHandSide, Expression rightHandSide, SourceCodeInformation sourceCodeInformation) {
        super(leftHandSide, rightHandSide, sourceCodeInformation);
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new BooleanType();
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitEqualTo(this);
    }
}
