package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.primary.Int;

public class Positive extends UnaryOperation {

	public Positive(ASTNode expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
