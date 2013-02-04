package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class Assign extends Stmt {
	private final Ident ident;
	private final Expr expr;

	public Assign(Ident ident, Expr expr) {
		this.ident = ident;
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	public Ident getIdent() {
		return ident;
	}
	
	@Override
	public void accept(IStmtVisitor visitor) {
		visitor.visit(this);
	}
}
