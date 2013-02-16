package org.uva.sea.ql.ast.literal;

import java.util.Map;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class IntegerLiteral extends Literal<Integer> {

	public IntegerLiteral(int n) {
		super(n);
	}

	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new Int();
	}
	
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
