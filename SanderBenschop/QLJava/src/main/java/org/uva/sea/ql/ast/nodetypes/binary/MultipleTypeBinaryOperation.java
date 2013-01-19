package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;

import java.util.Collection;

public abstract class MultipleTypeBinaryOperation extends BinaryOperation {

    public MultipleTypeBinaryOperation(QLExpression leftHandSide, QLExpression rightHandSide) {
        super(leftHandSide, rightHandSide);
    }

    public abstract Collection<Class<?>> getSupportedTypes();
}
