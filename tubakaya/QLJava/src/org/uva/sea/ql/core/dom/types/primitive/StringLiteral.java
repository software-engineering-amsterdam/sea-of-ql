package org.uva.sea.ql.core.dom.types.primitive;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;

public class StringLiteral extends Expression {

	public final String value;
	
	public StringLiteral(String string) {
		this.value=string;
	}
	
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);		
	}
}
