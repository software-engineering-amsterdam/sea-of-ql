package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class DecimalLit extends Value {
	private final float value;
	public DecimalLit(float value) {
		this.value=value;
	}

	public float getValue() {
		return value;
	}
	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);

	}

	@Override
	public Type getExprType(Map<String, Type> typeEnv) {
		return new MoneyType();
	}

}
