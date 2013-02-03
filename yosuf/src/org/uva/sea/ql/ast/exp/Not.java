package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Not extends Unary {

	public Not(final Expression operation) {
		super(operation);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public BooleanValue evaluate() {
		Value operationValue = getOperation().evaluate();

		return new BooleanValue(!((BooleanValue) operationValue).getValue());
	}
}
