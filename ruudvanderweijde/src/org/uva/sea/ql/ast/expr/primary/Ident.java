package org.uva.sea.ql.ast.expr.primary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Undefined;
import org.uva.sea.ql.visitor.ExpressionVisitor;


public class Ident extends Expr {

	private final String value;

	public Ident(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		// TODO return error;
		//return new Error();
		System.out.println("FIX THIS!!!! Error retreiving id...");
		return new Undefined();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
