package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;

public class TextLiteral extends Literal{

	private final String value;
 
	public TextLiteral(final String value) {
		super(DataType.TEXT);
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}

	@Override
	public String toString() {
		return "TextLiteral [value=" + value + "]";
	}
	
}
