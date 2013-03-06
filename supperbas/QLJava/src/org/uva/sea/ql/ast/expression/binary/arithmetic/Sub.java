package org.uva.sea.ql.ast.expression.binary.arithmetic;

import java.util.Map;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Visitor;
import org.uva.sea.ql.ast.expression.binary.Arithmetic;


public class Sub extends Arithmetic {

	public Sub(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.type.Int();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String getOperatorSymbol() {
		return "-";
	}

}
