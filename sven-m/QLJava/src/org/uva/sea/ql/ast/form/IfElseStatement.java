package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class IfElseStatement extends AbstractConditional {
	private final Body elseBody;

	public IfElseStatement(Expr condition, Body body, Body elseBody,
			Location startLocation) {
		super(condition, body, startLocation);
		this.elseBody = elseBody;
	}

	@Override
	public Location getLocation() {
		return new Location(getStartLocation(), elseBody.getLocation());
	}

	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Body getElse() {
		return elseBody;
	}

}
