package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.semanticchecker.ReturnType;

public class ComputedQuestion extends Question {

	private final Expr expr;
	
	public ComputedQuestion(Ident id, String label, Type type, Expr expr) {
		super(id, label, type);
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}

	@Override
	public ReturnType accept(StatementVisitor visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public boolean isDependent() {
		
		return true;
	}
	
	
	
}
