package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class IntegerLit extends Value {
	private final int value;
	public IntegerLit(int value) {
		this.value=value;

	}

	public int getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);
	}

	@Override
	public Type getExprType(Map<String, Type> typeEnv) {
		return new IntType();
	}

}
