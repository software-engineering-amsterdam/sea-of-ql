package org.uva.sea.ql.ast.expressions;

import java.util.Map;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.visitor.IExprVisitor;

public class BoolLiteral extends AExpr {
	private final boolean value;

	public BoolLiteral(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public AType typeOf(Map<Ident, AType> typeEnv) {
		return new BoolType();
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}