package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new IntType();
	}
}
