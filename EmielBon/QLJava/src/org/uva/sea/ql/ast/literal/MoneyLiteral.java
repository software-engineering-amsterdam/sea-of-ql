package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class MoneyLiteral extends Literal<Float> {

	public MoneyLiteral(Float n) {
		super(n);
	}

	public Type typeOf(TypeEnvironment env) {
		return new Money();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
