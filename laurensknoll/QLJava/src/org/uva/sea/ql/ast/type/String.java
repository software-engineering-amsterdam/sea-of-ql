package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.IType;

public class String extends AbstractType {

	@Override
	public <T> T accept(IType<T> visitor) {
		return visitor.visit(this);
	}

}
