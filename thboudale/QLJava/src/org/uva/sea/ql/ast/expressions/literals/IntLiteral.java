package org.uva.sea.ql.ast.expressions.literals;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.semanticCheck.ExprVisitor;

public class IntLiteral extends ALiteral {
	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public AType typeOf(Map<Ident, AType> typeEnv) {
		return new IntType();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}