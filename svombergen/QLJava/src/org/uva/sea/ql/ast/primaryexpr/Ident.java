package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Ident extends Str {

	public Ident(String n) {
		super(n);
	}
	
	public String getName() {
		return toString();
	}
	
	@Override
	public boolean isBoolean() {
		return true;
	}
	
	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}

}
