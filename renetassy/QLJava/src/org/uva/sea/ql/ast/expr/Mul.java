package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.Type;

public class Mul extends Binary {

	public Mul(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public boolean accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new NumericType();
	}

}
