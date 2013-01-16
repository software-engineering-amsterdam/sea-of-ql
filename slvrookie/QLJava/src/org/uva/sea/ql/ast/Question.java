package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.Visitor;

public class Question extends FormElement {

	private final Ident qID;
	private final StringLiteral qlabel;
	private final Type qtype;
	private Expr qexpr;

	public Question(Ident qID, StringLiteral qlabel, Type qtype) {
		this.qID = qID;
		this.qlabel = qlabel;
		this.qtype = qtype;
	}

	public Question(Ident qID, StringLiteral qlabel, Type qtype, Expr qexpr) {
		this.qID = qID;
		this.qlabel = qlabel;
		this.qtype = qtype;
		this.qexpr = qexpr;
	}

	public Ident getqID() {
		return qID;
	}

	public StringLiteral getqlabel() {
		return qlabel;
	}

	public Type getqType() {
		return qtype;
	}

	public Expr getqexpr() {
		return qexpr;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}
