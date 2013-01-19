package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;

public class Or extends SingleTypeBinaryOperation {

	public Or(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public Class<?> getSupportedType() {
        return Bool.class;
    }
}
