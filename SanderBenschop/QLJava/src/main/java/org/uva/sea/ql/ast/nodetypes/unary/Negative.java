package org.uva.sea.ql.ast.nodetypes.unary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.primary.Int;

public class Negative extends UnaryOperation {

	public Negative(ASTNode expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Int.class;
    }
}
