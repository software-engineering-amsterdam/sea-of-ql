package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class StringLiteral extends Literal<String> {

	public StringLiteral(String s) {
		super(s);
	}
	
	public Type typeOf(TypeEnvironment typeEnv) {
		return new Str();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
