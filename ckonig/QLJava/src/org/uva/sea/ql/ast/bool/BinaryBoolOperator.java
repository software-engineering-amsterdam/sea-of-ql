package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;

public class BinaryBoolOperator extends BinaryExpr implements BoolOperand,
		ASTElement {

	public BinaryBoolOperator(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
