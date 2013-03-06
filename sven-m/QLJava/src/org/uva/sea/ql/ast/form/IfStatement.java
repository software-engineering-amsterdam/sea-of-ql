package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class IfStatement extends AbstractConditional {

	public IfStatement(Expr condition, Body body, Location startLocation) {
		super(condition, body, startLocation);
	}

	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Location getLocation() {
		return new Location(getStartLocation(), getBody().getLocation());
	}

}
