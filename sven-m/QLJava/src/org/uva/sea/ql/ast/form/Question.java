package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Question extends FormElement {
	private final Ident name;
	private final String label;
	private final Type type;

	public Question(Ident name, String label, Type type) {
		this.name = name;
		this.label = label;
		this.type = type;
	}
	
	public Ident getName() {
		return name;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Type getType() {
		return type;
	}
	
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
