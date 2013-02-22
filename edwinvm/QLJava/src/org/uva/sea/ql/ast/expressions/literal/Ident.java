package org.uva.sea.ql.ast.expressions.literal;

import org.uva.sea.ql.ast.expressions.LiteralExpr;
import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public class Ident extends LiteralExpr {

	public Ident(String name) {
		super(name);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		if (typeEnvironment.contains(this)) {
			return typeEnvironment.get(this);
		}
		return new Error();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}