package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;

public class BooleanLiteral extends Expression {

	public final boolean value;

	public BooleanLiteral(String string) {
		this.value = Boolean.parseBoolean(string);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new BooleanType();
	}
}
