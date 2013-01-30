package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class Or extends Binary {

	public Or(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public boolean accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
