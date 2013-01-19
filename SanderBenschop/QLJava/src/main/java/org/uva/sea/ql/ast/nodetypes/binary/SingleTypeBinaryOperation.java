package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;

public abstract class SingleTypeBinaryOperation extends BinaryOperation {

    public SingleTypeBinaryOperation(QLExpression leftHandSide, QLExpression rightHandSide) {
        super(leftHandSide, rightHandSide);
    }

    public abstract Class<?> getSupportedType();
}