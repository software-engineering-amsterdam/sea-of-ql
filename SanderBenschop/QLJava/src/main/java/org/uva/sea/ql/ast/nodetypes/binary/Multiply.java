package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.primary.Int;

public class Multiply extends SingleTypeBinaryOperation {

	public Multiply(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
