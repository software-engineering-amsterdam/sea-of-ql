package org.uva.sea.ql.ast.stmt.question;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.FormVisitor;

public class ComputedQuestion extends Question {

	private final Expr computation;
	
	public ComputedQuestion(Ident id, String label, Type type, Expr computation) {
		super(id, label, type);
		this.computation = computation;
	}

	public Expr getComputation() {
		return computation;
	}
	
	@Override
	public void accept(FormVisitor visitor) {
		visitor.visit(this);
	}
}
