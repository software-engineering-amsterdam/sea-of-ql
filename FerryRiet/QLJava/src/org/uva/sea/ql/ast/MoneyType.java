package org.uva.sea.ql.ast;

public class MoneyType extends TypeDescription {

	private Expr expr;

	public Expr getExpr() {
		return expr;
	}

	public MoneyType(Expr x) {
		super("money") ;
		expr = x;
	}
}
