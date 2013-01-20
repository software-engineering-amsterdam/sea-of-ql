package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class Question extends FormElement {

	private final Ident qID;
	private final StringLiteral qlabel;
	private final Type qtype;

	public Question(Ident qID, StringLiteral qlabel, Type qtype) {
		this.qID = qID;
		this.qlabel = qlabel;
		this.qtype = qtype;
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


	@Override
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);
		
	}

}
