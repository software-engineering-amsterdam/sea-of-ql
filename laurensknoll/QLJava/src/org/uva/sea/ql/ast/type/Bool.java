package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public class Bool extends AbstractType {

	public java.lang.String getType() {
		return "Boolean";
	}

	@Override
	public void accept(AnswerTypeVisitor<?> visitor) {
		visitor.visit(this);
	}

}
