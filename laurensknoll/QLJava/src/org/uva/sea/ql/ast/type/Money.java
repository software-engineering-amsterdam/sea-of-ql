package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.Type;

public class Money extends Numeric {

	@Override
	public java.lang.String getType() {
		return "Money";
	}

	@Override
	public <T> T accept(Type<T> visitor) {
		return visitor.visit(this);
	}

}
