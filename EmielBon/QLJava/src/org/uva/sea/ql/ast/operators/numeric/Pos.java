package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.UnaryOperator;

// public class Pos implements ASTNode (originally)

public class Pos extends UnaryOperator {

	public Pos(Expr operand) {
		super(operand);
	}
	
}
