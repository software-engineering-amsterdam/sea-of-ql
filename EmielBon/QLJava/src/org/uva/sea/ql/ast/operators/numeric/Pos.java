package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.UnaryOperator;

// public class Pos implements ASTNode (originally)

public class Pos extends UnaryOperator {

	public Pos(Expression operand) {
		super(operand);
	}
	
}
