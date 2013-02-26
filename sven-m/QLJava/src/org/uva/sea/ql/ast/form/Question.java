package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.types.Type;
import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Question extends FormElement {
	private final Ident ident;
	private final String label;
	private final Type type;

	public Question(Ident ident, String label, Type type) {
		this.ident = ident;
		this.label = label;
		this.type = type;
	}

	public Ident getIdent() {
		return ident;
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

	@Override
	public Location getLocation() {
		return new Location(ident.getLocation(), type.getLocation());
	}

}
