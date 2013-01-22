package org.uva.sea.ql.ast.nodetypes.unary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.nodetypes.primary.Int;

public class Positive extends UnaryOperation {

	public Positive(ASTNode expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
