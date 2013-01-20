package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;

public class BinaryMathOperator extends BinaryExpr implements MathOperand, ASTElement {

	public BinaryMathOperator(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

}
