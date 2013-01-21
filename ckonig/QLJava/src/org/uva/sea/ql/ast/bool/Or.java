package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.AcceptsBoolOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Or extends BinaryExpr implements AcceptsBoolOperands,
		ReturnsBoolOperands {
	public static final String str = "||";

	public Or(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public void accept(ASTVisitor visitor) throws VisitorException {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return str;
	}
}
