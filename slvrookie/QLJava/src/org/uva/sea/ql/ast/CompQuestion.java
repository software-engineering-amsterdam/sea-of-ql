package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.TypeChecker;

public class CompQuestion extends Question {

	private final Expr qExpr;

	public CompQuestion(Ident qID, StringLiteral qString, Type qType, Expr qExpr) {
		
		super(qID, qString, qType);
		this.qExpr = qExpr;
	}

	public Expr getQuestionExpr() {
		return qExpr;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);
		
	}

}
