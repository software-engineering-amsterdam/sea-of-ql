package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.type.Type;

public class FormText extends FormField {

	protected Expression calculation;
	
	public FormText(Identifier id, StringPrimitive label, Type type, Expression calculation) {
		super(id, label, type);
		this.calculation = calculation;
	}
	
}
