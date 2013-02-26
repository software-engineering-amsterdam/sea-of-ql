package org.uva.sea.ql.ast.types.primitive;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;

public class BooleanLiteral extends Expression {

	public final boolean value;

	public BooleanLiteral(String string) {
		this.value = Boolean.parseBoolean(string);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public TypeDeclaration getType() {
		return new BooleanDeclaration();
	}
}
