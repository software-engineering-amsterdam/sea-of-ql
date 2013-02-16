package org.uva.sea.ql.ast.literal;

import java.util.Map;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class BooleanLiteral extends Literal<Boolean> {

	public BooleanLiteral(boolean b) {
		super(b);
	}

	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new Bool();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
