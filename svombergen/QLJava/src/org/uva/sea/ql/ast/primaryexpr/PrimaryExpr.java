package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class PrimaryExpr extends Expr {
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
