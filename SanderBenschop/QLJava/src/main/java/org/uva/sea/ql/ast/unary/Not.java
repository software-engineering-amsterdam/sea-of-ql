package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.Bool;

public class Not extends UnaryOperation {

	public Not(QLExpression expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Bool.class;
    }
}
