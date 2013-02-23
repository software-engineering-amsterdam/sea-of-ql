package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.semanticCheck.FormStmtVisitor;

public class ComputedQuestion extends Question {
	private final AExpr orExpr;

	public ComputedQuestion(Ident ident, String label, AType type, AExpr orExpr) {
		super(ident, label, type);
		this.orExpr = orExpr;
	}
		
	public AExpr getExpr() {
		return orExpr;
	}
	
	@Override
	public <T> T accept(FormStmtVisitor<T> visitor) {
		return visitor.visit(this);		
	}
}