package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.Value;

public class StringType extends Value{

	private final String value; 
	
	public StringType(String value)
	{
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
