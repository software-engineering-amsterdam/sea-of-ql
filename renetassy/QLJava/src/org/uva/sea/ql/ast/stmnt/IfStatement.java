package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.ast.StatementChecker;
import org.uva.sea.ql.ast.expr.Expr;

public class IfStatement extends Statement {
	
	private Expr expr;
	private Body body;
	
	public IfStatement (Expr expr, Body body) {
		this.expr=expr;
		this.body=body;
	}
	
	public Body getBody() {
		return body;
	}
	
	public Expr getExpr() {
		return expr;
	}

	@Override
	public boolean accept(StatementChecker visitor) {
		return visitor.visit(this);
	}

}
