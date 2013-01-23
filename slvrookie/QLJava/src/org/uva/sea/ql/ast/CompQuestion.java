package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;


public class CompQuestion extends FormElement {

	private final Ident qID;
	private final StringLiteral qString;
	private final Type qType;
	private Expr qExpr;

	public CompQuestion(Ident qID, StringLiteral qString, Type qType, Expr qExpr) {
		this.qID = qID;
		this.qString = qString;
		this.qType = qType;
		this.qExpr = qExpr;
	}

	public Ident getQuestionID() {
		return qID;
	}

	public StringLiteral getQuestionString() {
		return qString;
	}

	public Type getQuestionType() {
		return qType;
	}

	public Expr getQuestionExpr() {
		return qExpr;
	}

}
