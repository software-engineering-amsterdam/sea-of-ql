package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.Type;

public class MoneyLiteral extends Expression {

	public final int value;

	public MoneyLiteral(String string) {
		this.value = Integer.parseInt(string);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
