package org.uva.sea.ql.ast.operators.unary;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Neg extends UnaryOperator {
	public Neg(final Node node) {
		super(node);
	}
	
	@Override
	public void accept(IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
