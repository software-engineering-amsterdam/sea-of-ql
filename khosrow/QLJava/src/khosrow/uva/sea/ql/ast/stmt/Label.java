package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.expr.StringLiteral;

public class Label extends Stmt {
	private final String text;
	private Expr expr;
	
	public Label(StringLiteral text, Expr expr){
		this.text = text.getValue();
		this.setExpr(expr);
	}

	public String getText() {
		return text;
	}

	public Expr getExpr() {
		return expr;
	}

	public void setExpr(Expr expr) {
		this.expr = expr;
	}

}
