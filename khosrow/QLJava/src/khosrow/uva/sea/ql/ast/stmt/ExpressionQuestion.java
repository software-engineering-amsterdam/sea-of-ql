package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.expr.StringLiteral;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class ExpressionQuestion extends Question {
	private final Expr expr;
	
	public ExpressionQuestion(Ident ident, Expr expr, StringLiteral text, Type type) {
		super(ident, text.getValue(), type);
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}

	@Override
	public void accept(IStmtVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
