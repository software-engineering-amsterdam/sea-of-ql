package org.uva.sea.ql.ast.expression.binary.comparison;

import java.util.Map;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.binary.Comparison;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Visitor;


public class LEq extends Comparison {

	public LEq(Expression lhs, Expression rhs) {
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
		return "<=";
	}

}
