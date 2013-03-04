package org.uva.sea.ql.ast.expression.unary;

import java.util.Map;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Unary;
import org.uva.sea.ql.ast.expression.Visitor;


public class Not extends Unary {

	public Not(Expression expr) {
		super(expr);
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
		return "(!)";
	}

}
