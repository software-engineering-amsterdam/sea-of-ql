package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Pos extends Unary {

	public Pos(Expr op, Location startLocation) {
		super(op, startLocation);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
