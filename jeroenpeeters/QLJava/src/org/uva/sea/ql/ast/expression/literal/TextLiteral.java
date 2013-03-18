package org.uva.sea.ql.ast.expression.literal;

import java.util.Map;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.TextType;
import org.uva.sea.ql.ast.type.Type;

public class TextLiteral extends Literal{

	private final String value;
 
	public TextLiteral(final String value) {
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	@Override
	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new TextType();
	}

	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}

	@Override
	public String toString() {
		return "TextLiteral [value=" + value + "]";
	}
	
}
