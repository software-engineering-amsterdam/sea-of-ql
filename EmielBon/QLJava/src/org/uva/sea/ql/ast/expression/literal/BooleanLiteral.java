package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.typechecker.ExpressionVisitor;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class BooleanLiteral extends Literal<Boolean> {

	public BooleanLiteral(boolean b) {
		super(b);
	}

	public Type typeOf(TypeEnvironment typeEnv) {
		return new Bool();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
