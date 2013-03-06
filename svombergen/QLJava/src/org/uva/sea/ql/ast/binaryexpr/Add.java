package org.uva.sea.ql.ast.binaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Add extends BinaryExpr {	
	
	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	public boolean accept(ExpressionVisitor visitor) {
		return visitor.visit(this);
	}
}
