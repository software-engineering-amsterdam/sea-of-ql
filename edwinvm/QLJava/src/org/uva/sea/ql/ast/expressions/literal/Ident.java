package org.uva.sea.ql.ast.expressions.literal;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.LiteralExpr;
import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.visitors.checkexpr.Visitor;
import org.uva.sea.ql.parser.SupportedTypes;

public class Ident extends LiteralExpr {

	public Ident(String name) {
		super(name);
	}
	@Override
	public Type typeOf(SupportedTypes supportedTypes) {
		if (supportedTypes.contains(this)) {
			return supportedTypes.get(this);
		}
		return new Error();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}