package org.uva.sea.ql.ast.expression.literals;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Literal;

public class TextLiteral extends Literal{

	private final String value;
 
	public TextLiteral(final String value) {
		super(DataType.TEXT);
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
}
