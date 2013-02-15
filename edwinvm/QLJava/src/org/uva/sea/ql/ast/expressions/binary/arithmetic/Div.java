package org.uva.sea.ql.ast.expressions.binary.arithmetic;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.binary.BinaryArithmeticExpr;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;

public class Div extends BinaryArithmeticExpr {
	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}