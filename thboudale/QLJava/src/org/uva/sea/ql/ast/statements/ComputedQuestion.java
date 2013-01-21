package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;

public class ComputedQuestion extends Statement {
	private final Ident ident;
	private final String strLit;
	private final String type;
	private final Expr orExpr;

	public ComputedQuestion(Ident ident, String strLit, String type, Expr orExpr) {
		this.ident = ident;
		this.strLit = strLit;
		this.type = type;
		this.orExpr = orExpr;
	}
	
	public Ident getIdentifier() {
		return ident;
	}
	
	public String getStrLit() {
		return strLit;
	}
	
	public String getType() {
		return type;
	}
}