package org.uva.sea.ql.ast.statements.types;

import org.uva.sea.ql.ast.Expr;

public class MoneyExprType extends MoneyType {
	
	protected Expr addExpr;
	
	public MoneyExprType(Expr exp){
		addExpr = exp;
	}
	
	public Expr getExpr() {
		return addExpr;
	}
	
}
