package khosrow.uva.sea.ql.ast.expr;


public abstract class Binary extends Expr {
	private final Expr lhs;
	private final Expr rhs;

	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	protected Expr getLhs() {
		return lhs;
	}
	
	protected Expr getRhs() {
		return rhs;
	}
	
}
