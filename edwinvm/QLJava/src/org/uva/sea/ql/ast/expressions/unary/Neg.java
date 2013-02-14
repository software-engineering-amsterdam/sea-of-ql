package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.visitors.checkexpr.Visitor;
import org.uva.sea.ql.parser.SupportedTypes;

public class Neg extends UnaryExpr {
	public Neg(Expr expr) {
		super(expr);
	}
	
	@Override
	public Type typeOf(SupportedTypes supportedTypes) {
		return new Numeric();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}