package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class ElseStatement extends AbstractIfThenElse {
	public ElseStatement(Body body, Location startLocation) {
		super(body, startLocation);
	}
	
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
