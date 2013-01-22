package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.primitive.StringPrimitive;
import org.uva.sea.ql.ast.types.Type;

public class FormField extends FormElement {
	protected Identifier id;
	protected StringPrimitive label;
	protected Type type;
	
	public FormField(Identifier id,  StringPrimitive label, Type type) {
		this.id    = id;
		this.label = label;
		this.type  = type;
	}
}
