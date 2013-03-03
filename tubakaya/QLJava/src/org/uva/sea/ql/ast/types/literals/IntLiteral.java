package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.Type;

public class IntLiteral extends QLValue {

	public final int value;

	public IntLiteral(String string) {
		this.value = Integer.parseInt(string);
	}
	
	public IntLiteral(Integer value) {
		this.value = value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type accept(ExpressionTypeVisitor visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Integer getIntegerValue() {
		return this.value;
	}
}
