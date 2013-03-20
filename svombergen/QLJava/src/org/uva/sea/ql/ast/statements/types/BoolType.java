package org.uva.sea.ql.ast.statements.types;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.gui.FormRenderer;

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
	public void accept(FormRenderer v) {
		v.visit(this);
	}
}
