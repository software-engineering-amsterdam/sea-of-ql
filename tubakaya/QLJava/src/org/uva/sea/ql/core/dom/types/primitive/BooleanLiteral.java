package org.uva.sea.ql.core.dom.types.primitive;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;

public class BooleanLiteral extends Expression{

	public final boolean value;
	
	public BooleanLiteral(String string) {
		this.value=Boolean.parseBoolean(string);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);		
	}

}
