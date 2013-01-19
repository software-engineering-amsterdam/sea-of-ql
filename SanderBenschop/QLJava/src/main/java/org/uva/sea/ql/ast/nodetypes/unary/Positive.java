package org.uva.sea.ql.ast.nodetypes.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.primary.Int;

public class Positive extends UnaryOperation {

	public Positive(QLExpression expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
