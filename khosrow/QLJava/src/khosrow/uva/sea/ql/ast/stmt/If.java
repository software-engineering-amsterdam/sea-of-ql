package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;


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

	@Override
	public <T> T accept(IStmtVisitor<T> visitor) {		
		return visitor.visit(this);
	}	
}
