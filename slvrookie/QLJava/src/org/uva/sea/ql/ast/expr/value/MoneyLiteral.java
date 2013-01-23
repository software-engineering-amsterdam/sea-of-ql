package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IVisitor;

public class MoneyLiteral extends Expr {

	private final double value;

	public MoneyLiteral(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new MoneyType() ;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
