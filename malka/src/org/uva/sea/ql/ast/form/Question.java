package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.type.Type;

public class Question extends FormField {

	public Question(Identifier id, StringPrimitive label, Type type) {
		super(id, label, type);
	}
	
}
