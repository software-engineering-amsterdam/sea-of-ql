package org.uva.sea.ql.ast.types.primitive;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;

public class MoneyLiteral extends Expression {

	public final int value;

	public MoneyLiteral(String string) {
		this.value = Integer.parseInt(string);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public TypeDeclaration getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
