package org.uva.sea.ql.errors;

//import org.uva.sea.ql.ast.expr.Expr;

public class ExprError extends QLError {
	
	//private Expr expr;
	private String operator;
	
	public ExprError(String operator) {
		//this.expr = expr;
		this.operator = operator;
	}
	
	//public Expr getExpr() {
		//return expr;
	//}
	
	public String getOperator() {
		return operator;
	}

	@Override
	public void accept(QLErrorPrinter visitor) {
		visitor.visit(this);
	}
	
}
