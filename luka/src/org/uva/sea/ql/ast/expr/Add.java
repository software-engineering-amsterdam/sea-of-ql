package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Add extends BinaryExpr {

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);

	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new NumericType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "ADD lhs(" + this.lhs.toString() + ")" + " |Êrhs(" + this.rhs.toString()
				+ ")";
	}
}
