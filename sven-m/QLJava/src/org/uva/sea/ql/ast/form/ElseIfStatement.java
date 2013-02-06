package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class ElseIfStatement extends AbstractConditional {
	public ElseIfStatement(Expr condition, Body body) {
		super(condition, body);
	}
	
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
