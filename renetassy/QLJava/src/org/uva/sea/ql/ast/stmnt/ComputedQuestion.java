package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.IStatementVisitor;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class ComputedQuestion extends Question {
	
	private Expr expr;

	public ComputedQuestion(Ident id, StringLiteral label, Type type, Expr expr) {
		super(id, label, type);
		this.expr=expr;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
