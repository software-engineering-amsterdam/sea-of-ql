package org.uva.sea.ql.ast;

public class Add extends BinaryExpr{
	public static final String str = "+";
	
	public Add(Expr left, Expr right){
		super(left,right);
	}
}
