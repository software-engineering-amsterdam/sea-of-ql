package org.uva.sea.ql.core.dom.types.primitive;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.types.declarations.StringDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;

public class StringLiteral extends Expression {

	public final String value;

	public StringLiteral(String string) {
		this.value = string;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public TypeDeclaration getType() {
		return new StringDeclaration();
	}
}
