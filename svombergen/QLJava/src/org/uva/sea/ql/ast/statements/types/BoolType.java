package org.uva.sea.ql.ast.statements.types;

import org.uva.sea.ql.ast.*;

public class BoolType implements Type {
	protected String name = "boolean";
	
	public Expr getExpr(){
		return null;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof BoolType);
	}
}
