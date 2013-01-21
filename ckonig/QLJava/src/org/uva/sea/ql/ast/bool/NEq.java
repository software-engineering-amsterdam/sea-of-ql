package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.AcceptsBothOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.visitor.ASTVisitor;

public class NEq extends BinaryExpr implements AcceptsBothOperands, ReturnsBoolOperands {
	public static final String str = "!=";

	public NEq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
}
