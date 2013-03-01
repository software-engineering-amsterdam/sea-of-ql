package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.Type;

public class BooleanLiteral extends QLValue {

	private final boolean value;

	public BooleanLiteral(String string) {
		this.value = Boolean.parseBoolean(string);
	}
	
	public BooleanLiteral(Boolean value) {
		this.value = value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type accept(ExpressionTypeVisitor visitor) {
		return visitor.visit(this);
	}

	public boolean getValue() {
		return value;
	}
	
	@Override
	public Boolean getBooleanValue() {
		return this.value;
	}
}
