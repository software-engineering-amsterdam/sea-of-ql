package org.uva.sea.ql.ast.expressions;

import java.util.Map;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.visitor.IExprVisitor;

public class IntLiteral extends AExpr {
	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public AType typeOf(Map<Ident, AType> typeEnv) {
		return new IntType();
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}