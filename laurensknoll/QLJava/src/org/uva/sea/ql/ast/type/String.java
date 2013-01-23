package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.Type;

public class String extends AbstractType {

	public java.lang.String getType() {
		return "String";
	}

	@Override
	public <T> T accept(Type<T> visitor) {
		return visitor.visit(this);
	}

}
