package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class ElseIfStatement extends AbstractConditional {
	public ElseIfStatement(Expr condition, Body body, Location startLocation) {
		super(condition, body, startLocation);
	}
	
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
