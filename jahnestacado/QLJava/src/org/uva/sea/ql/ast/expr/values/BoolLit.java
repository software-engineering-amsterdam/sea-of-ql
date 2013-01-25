package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.checkers.ExpressionChecker;

public class BoolLit extends Value<Boolean> {

	public BoolLit(boolean value) {
		super(value);
	}

	@Override
	public boolean accept(ExpressionChecker nodeVisitor) {
		return nodeVisitor.visit(this);

	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
