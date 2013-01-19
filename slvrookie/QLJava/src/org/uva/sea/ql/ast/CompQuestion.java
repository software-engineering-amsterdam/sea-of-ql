package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.Visitor;

public class CompQuestion implements FormElement {
	
	private final Ident qID;
	private final StringLiteral qlabel;
	private final Type qtype;
	private Expr qexpr;

	public CompQuestion(Ident qID, StringLiteral qlabel, Type qtype, Expr qexpr) {
		this.qID = qID;
		this.qlabel = qlabel;
		this.qtype = qtype;
		this.qexpr = qexpr;
	}

	public Ident getQuestionID() {
		return qID;
	}

	public StringLiteral getQuestionLabel() {
		return qlabel;
	}

	public Type getQuestionType() {
		return qtype;
	}

	public Expr getQuestionExpr() {
		return qexpr;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}
}
