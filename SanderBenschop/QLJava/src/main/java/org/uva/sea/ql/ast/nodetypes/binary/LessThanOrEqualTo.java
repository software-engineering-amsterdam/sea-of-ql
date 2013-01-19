package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.primary.Int;

public class LessThanOrEqualTo extends SingleTypeBinaryOperation {

	public LessThanOrEqualTo(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
