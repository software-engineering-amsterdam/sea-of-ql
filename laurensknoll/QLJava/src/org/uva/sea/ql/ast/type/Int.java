package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.Type;

public class Int extends Numeric {

	@Override
	public java.lang.String getType() {
		return "Integer";
	}

	@Override
	public <T> T accept(Type<T> visitor) {
		return visitor.visit(this);
	}

}
