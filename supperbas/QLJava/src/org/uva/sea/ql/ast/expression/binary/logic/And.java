package org.uva.sea.ql.ast.expression.binary.logic;

import java.util.Map;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.binary.Logic;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Visitor;


public class And extends Logic {

	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String getOperatorSymbol() {
		return "&&";
	}

}
