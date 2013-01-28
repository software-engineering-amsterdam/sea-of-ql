package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.Expr;


public class If extends Stmt {

	private final Expr cond;
	private final Stmts body;

	public If(Expr cond, Stmts body) {
		this.cond = cond;
		this.body = body;
	}

	public Expr getCond() {
		return cond;
	}

	public Stmts getBody() {
		return body;
	}
}
