package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.primary.Bool;

public class Not extends UnaryOperation {

	public Not(ASTNode expression) {
		super(expression);
	}

    @Override
    public Class<?> getSupportedType() {
        return Bool.class;
    }
}
