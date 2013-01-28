package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.Int;

public class Positive extends UnaryOperation {

	public Positive(QLExpression expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
