package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.Type;

public class Bool extends AbstractType {

	public java.lang.String getType() {
		return "Boolean";
	}

	@Override
	public void accept(Type<?> visitor) {
		visitor.visit(this);
	}

}
