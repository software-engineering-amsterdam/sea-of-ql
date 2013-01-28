package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.primitive.StringPrimitive;
import org.uva.sea.ql.ast.types.Type;

public class FormText extends FormField {

	protected Expression calculation;
	
	public FormText(Identifier id, StringPrimitive label, Type type, Expression calculation) {
		super(id, label, type);
		this.calculation = calculation;
	}
	
}
