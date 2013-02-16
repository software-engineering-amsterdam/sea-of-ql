package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class BoolLit extends Value {
	private final boolean value;

	public BoolLit(boolean value) {
		this.value=value;
	}

	public boolean getValue() {
		return value;
	}
	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);

	}

	@Override
	public Type getExprType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
