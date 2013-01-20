package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.Literal;

public class Text extends Literal{

	private final String value;
 
	public Text(final String value) {
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
}
