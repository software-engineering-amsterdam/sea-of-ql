package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.Expr;

public class StringLit extends Expr  {
    private final String value;
	
	public StringLit(String value) {
		this.value=value;
		
	}

}
