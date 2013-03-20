package org.uva.sea.ql.ast.statements.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.gui.FormRenderer;

public class StrType implements Type {
	public Expr getExpr(){
		return null;
	}

	@Override
	public void accept(FormRenderer v) {
		v.visit(this);
	}
}
