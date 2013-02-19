package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.checkers.ElementChecker;

public class IfThen extends ConditionalElement{

	

	public IfThen(Expr condition, Body body) {
		super(condition,body);
	}

	@Override
	public void accept(ElementChecker qlElement) {
			qlElement.visit(this);
	}

	

}
