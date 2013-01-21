package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.*;
import java.lang.String;

public class String_lit extends Type{
	private final String value;
	
	public String_lit(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}
}
