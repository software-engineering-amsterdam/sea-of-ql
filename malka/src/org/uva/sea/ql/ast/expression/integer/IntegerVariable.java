package org.uva.sea.ql.ast.expression.integer;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class IntegerVariable extends Variable implements IntegerExpression {
	
	public IntegerVariable(Identifier id) {
		super(id);
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}

}
