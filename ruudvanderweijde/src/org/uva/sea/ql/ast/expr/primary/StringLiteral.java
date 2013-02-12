package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.type.StringType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

public class StringLiteral extends Primary<String> {

	private final String value;

	public StringLiteral(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "StringLiteral";
	}

	@Override
	public Type typeOf(TypeMapper typeMapper) {
		return new StringType();
	}


	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
