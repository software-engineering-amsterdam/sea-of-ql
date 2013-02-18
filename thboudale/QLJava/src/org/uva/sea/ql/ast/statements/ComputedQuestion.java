package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Str;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.StmtVisitor;

public class ComputedQuestion extends Question {
	private final Expr orExpr;

	public ComputedQuestion(Ident ident, Str strLtr, Type type, Expr orExpr) {
		super(ident, strLtr, type);
		this.orExpr = orExpr;
	}
		
	public Expr getExpr() {
		return orExpr;
	}
	
	@Override
	public void accept(StmtVisitor visitor) {
		visitor.visit(this);		
	}
}