package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.IType;

public class Money extends Numeric {

	@Override
	public <T> T accept(IType<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Money;
	}

}
