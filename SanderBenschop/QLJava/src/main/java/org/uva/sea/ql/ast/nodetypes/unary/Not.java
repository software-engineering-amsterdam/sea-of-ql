package org.uva.sea.ql.ast.nodetypes.unary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;

public class Not extends UnaryOperation {

	public Not(ASTNode expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Bool.class;
    }
}
