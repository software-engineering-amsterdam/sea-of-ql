package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class Decimal extends Value<Float> {

	public Decimal(float value) {
		super(value);
	}

	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);

	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new MoneyType();
	}

}
