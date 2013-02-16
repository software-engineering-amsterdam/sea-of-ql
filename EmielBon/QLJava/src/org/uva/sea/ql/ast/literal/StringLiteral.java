package org.uva.sea.ql.ast.literal;

import java.util.Map;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class StringLiteral extends Literal<String> {

	public StringLiteral(String s) {
		super(s);
	}
	
	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new Str();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
