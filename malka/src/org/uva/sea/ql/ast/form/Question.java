package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.primitive.StringPrimitive;
import org.uva.sea.ql.ast.types.Type;

public class Question extends FormField {

	public Question(Identifier id, StringPrimitive label, Type type) {
		super(id, label, type);
	}
	
}
