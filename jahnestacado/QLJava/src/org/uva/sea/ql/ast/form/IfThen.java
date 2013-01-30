package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.IElementVisitor;

public class IfThen extends ConditionalElement{

	

	public IfThen(Expr condition, Body body) {
		super(condition,body);
	}

	@Override
	public void accept(IElementVisitor qlElement) {
			qlElement.visit(this);
	}

	

}
