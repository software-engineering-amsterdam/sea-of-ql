package org.uva.sea.ql.ast.expressions.literal;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.LiteralExpr;
import org.uva.sea.ql.ast.visitors.checkexpr.Visitor;
import org.uva.sea.ql.parser.SupportedTypes;

public class Str extends LiteralExpr {

	public Str(String value) {
		super(value);
	}

	@Override
	public Type typeOf(SupportedTypes supportedTypes) {
		return new org.uva.sea.ql.ast.types.Str();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}