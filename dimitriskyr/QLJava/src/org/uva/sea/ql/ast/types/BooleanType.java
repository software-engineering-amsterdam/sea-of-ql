package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class BooleanType extends Type{
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
