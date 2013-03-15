package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;

public abstract class FormField extends FormElement {
	protected Identifier id;
	protected StringPrimitive label;
	protected Type type;
	protected Variable variable;
	
	public FormField(Identifier id,  StringPrimitive label, Type type) {
		this.id    = id;
		this.label = label;
		this.type  = type;
		variable = type.getVariable(id);
	}
	
	public Variable getVariable() {
		return variable;
	}
	
	public String getLabel() {
		return label.evaluate();
	}
	
	public Identifier getId() {
		return	this.id;
	}

	public Type getType() {
		return type;
	}
}