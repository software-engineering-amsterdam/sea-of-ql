package khosrow.uva.sea.ql.ast.expr;

public abstract class Unary extends Expr {
	private final Expr arg;
	
	protected Unary(Expr arg) {
		this.arg = arg;
	}
	
	protected Expr getArg() {
		return arg;
	}
	
}
