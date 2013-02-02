package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

import java.lang.String;

public class String_lit extends Value{
	private final String value;
	
	public String_lit(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
