package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;

public class TextLiteral extends Literal{

	private final String value;
 
	public TextLiteral(final String value) {
		super(DataType.TEXT);
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}

	@Override
	public String toString() {
		return "TextLiteral [value=" + value + "]";
	}
	
}
