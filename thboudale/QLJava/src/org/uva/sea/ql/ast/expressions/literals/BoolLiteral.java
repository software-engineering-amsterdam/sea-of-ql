package org.uva.sea.ql.ast.expressions.literals;

import java.util.Map;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.semanticCheck.ExprVisitor;

public class BoolLiteral extends ALiteral {
	private final boolean value;

	public BoolLiteral(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}
	
	@Override
	public AType typeOf(Map<Ident, AType> typeEnv) {
		return new BoolType();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}