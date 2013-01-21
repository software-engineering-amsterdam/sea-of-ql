package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsMathOperands;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Add extends BinaryExpr implements AcceptsMathOperands, ReturnsMathOperands {
	public static final String str = "+";
	
	public Add(Expr left, Expr right){
		super(left,right);
	}
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);		
	}
}
