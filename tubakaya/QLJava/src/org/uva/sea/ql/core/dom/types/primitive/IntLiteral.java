package org.uva.sea.ql.core.dom.types.primitive;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;

public class IntLiteral extends Expression {

	public final int value;
	
	public IntLiteral(String string) {
		this.value=Integer.parseInt(string);
	}
	
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);		
	}
}
