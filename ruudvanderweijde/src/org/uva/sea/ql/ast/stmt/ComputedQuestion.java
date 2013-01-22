package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.FormVisitor;

public class ComputedQuestion extends Statement {

	private final Ident id;
	private final String label;
	private final Type type;
	private final Expr computation;
	
	public ComputedQuestion(Ident id, String label, Type type, Expr computation) {
		this.id = id;
		this.label = label;
		this.type = type;
		this.computation = computation;
	}
	
	public Ident getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	public Expr getComputation() {
		return computation;
	}
	
	@Override
	public void accept(FormVisitor visitor) {
		visitor.visit(this);
	}
}
