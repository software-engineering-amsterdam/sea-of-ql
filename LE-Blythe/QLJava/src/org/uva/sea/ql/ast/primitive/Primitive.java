package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Expr;

public abstract class Primitive extends Expr{
	
	public abstract String toString();

	public boolean isDefined(){
		return true;
	}

}
