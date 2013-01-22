package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

public class LT extends BinaryExpr implements AcceptsMathOperands, ReturnsBoolOperands {
	public static final String str = "<";

	public LT(Expr left, Expr right) {
		super(left, right);
	}
	@Override
	public void accept(ASTVisitor visitor) throws VisitorException {
		visitor.visit(this);		
	}
}