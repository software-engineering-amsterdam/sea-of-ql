package eu.karuza.ql.ast;


import eu.karuza.ql.ast.expr.grouping.Expr;
import eu.karuza.ql.visitor.StatementVisitor;

public class ComputedQuestion extends Question {

	private static final long serialVersionUID = -3800615516409462911L;
	private Expr expr;
	
	public ComputedQuestion(String name, String label, Expr expr, int lineNumber) {
		super(name, label, lineNumber);
		this.expr = expr;
	}
	
	@Override
	public Expr getExpr() {
		return expr;
	}

	@Override
	public void accept(StatementVisitor<?> visitor) {
		visitor.visit(this);
	}

}
