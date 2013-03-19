package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.typechecker.TypeEnvironment;

/**
 * A class representing the boolean literals "true" and "false"
 */
public class BooleanLiteral extends Literal<Boolean> {

	public BooleanLiteral(boolean b) {
		super(b);
	}

	public Type typeOf(TypeEnvironment env) {
		return new Bool();
	}
	
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
