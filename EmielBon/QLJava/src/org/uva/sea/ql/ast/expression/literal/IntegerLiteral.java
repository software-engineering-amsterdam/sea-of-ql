package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class IntegerLiteral extends Literal<Integer> {

	public IntegerLiteral(int n) {
		super(n);
	}

	public Type typeOf(TypeEnvironment typeEnv) {
		return new Int();
	}
	
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
