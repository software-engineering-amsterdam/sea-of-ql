package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Question extends FormField {

	public Question(Identifier id, StringPrimitive label, Type type) {
		super(id, label, type);
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
}
