package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.Type;

public class StringLiteral extends QLValue {

	public final String value;

	public StringLiteral(String string) {
		this.value = string;
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
	public String getStringValue() {
		return this.value;
	}
}
