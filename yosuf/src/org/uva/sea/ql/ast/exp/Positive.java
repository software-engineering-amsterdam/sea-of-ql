package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Positive extends Unary {

	public Positive(final Expression operation) {
		super(operation);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public IntegerValue evaluate() {
		Value operationValue = getOperation().evaluate();

		return new IntegerValue(((IntegerValue) operationValue).getValue() + 1);
	}
}
