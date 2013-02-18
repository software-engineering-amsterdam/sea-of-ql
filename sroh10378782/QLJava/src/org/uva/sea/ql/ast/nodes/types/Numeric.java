package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.visitor.Visitor;

public class Numeric extends Type{
	
	@Override
	public String toString() {
		return "Numeric Type : ";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
