package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.Type;

public class IntLiteral extends Expression {

	public final int value;

	public IntLiteral(String string) {
		this.value = Integer.parseInt(string);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type accept(ExpressionTypeVisitor visitor) {
		return visitor.visit(this);
	}
}
