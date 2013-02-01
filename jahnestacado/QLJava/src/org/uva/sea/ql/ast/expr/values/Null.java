package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.UndefinedType;
import org.uva.sea.ql.visitor.IExprVisitor;

public class Null extends Value {

	public Null() {
		super(null);
	}

	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new UndefinedType();
	}

}
