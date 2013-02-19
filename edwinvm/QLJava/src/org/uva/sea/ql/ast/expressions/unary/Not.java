package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public class Not extends UnaryExpr {
	public Not(Expr expr) {
		super(expr);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new org.uva.sea.ql.ast.types.Bool();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}