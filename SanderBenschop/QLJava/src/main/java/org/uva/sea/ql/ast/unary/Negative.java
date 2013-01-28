package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.Int;

public class Negative extends UnaryOperation {

	public Negative(QLExpression expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
