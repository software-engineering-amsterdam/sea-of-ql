package org.uva.sea.ql.ast.expressions.literal;

import org.uva.sea.ql.ast.expressions.LiteralExpr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public class Int extends LiteralExpr {

	public Int(int value) {
		super(value);
	}

	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new org.uva.sea.ql.ast.types.Int();
	}	
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}