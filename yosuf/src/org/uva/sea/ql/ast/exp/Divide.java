package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Divide extends Binary {

	public Divide(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public IntegerValue evaluate() {
		Value left = getLeft().evaluate();
		Value right = getRight().evaluate();

		return new IntegerValue(((IntegerValue) left).getValue()
				/ ((IntegerValue) right).getValue());
	}

}
