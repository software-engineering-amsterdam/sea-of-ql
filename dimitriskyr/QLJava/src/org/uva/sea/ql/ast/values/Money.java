package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Money extends Value {
	private final float value;
	
	public Money(float value) {
		this.value=value;
	}
	
	public float getValue() {
		return value;
	}

	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new MoneyType();
	}

}
