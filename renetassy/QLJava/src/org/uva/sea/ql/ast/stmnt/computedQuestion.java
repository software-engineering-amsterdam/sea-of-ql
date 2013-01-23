package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.qtype.QuestionType;

public class computedQuestion extends Question {
	
	private Expr expr;

	public computedQuestion(Ident id, StringLiteral label, QuestionType type, Expr expr) {
		super(id, label, type);
		this.expr=expr;
	}

}
