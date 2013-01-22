package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.Type;

public class Int extends Numeric {

	public java.lang.String getType() {
		return "Integer";
	}

	@Override
	public void accept(Type<?> visitor) {
		visitor.visit(this);
	}

}
