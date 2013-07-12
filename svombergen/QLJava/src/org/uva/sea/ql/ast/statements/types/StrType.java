package org.uva.sea.ql.ast.statements.types;

import org.uva.sea.ql.ast.Expr;

public class StrType implements Type {
	public Expr getExpr(){
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof StrType);
	}
}
