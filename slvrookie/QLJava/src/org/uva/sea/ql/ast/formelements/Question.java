package org.uva.sea.ql.ast.formelements;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.IElementVisitor;

public class Question extends FormElement {

	private final Ident name;
	private final StringLiteral label;
	private final Type type;

	public Question(Ident name, StringLiteral label, Type type) {
		this.name = name;
		this.label = label;
		this.type = type;
	}

	public Ident getName() {
		return name;
	}

	public StringLiteral getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	@Override
	public void accept(IElementVisitor ElementVisitor) {
		ElementVisitor.visit(this);
	}

}
