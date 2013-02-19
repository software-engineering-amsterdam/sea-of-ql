package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class BooleanVariable extends Variable implements BooleanExpression {

	public BooleanVariable(Identifier id) {
		super(id);
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
	
}
