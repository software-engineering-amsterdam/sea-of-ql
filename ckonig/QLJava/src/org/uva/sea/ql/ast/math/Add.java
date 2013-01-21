package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.Expr;

public class Add extends BinaryMathOperator{
	public static final String str = "+";
	
	public Add(Expr left, Expr right){
		super(left,right);
	}
}
