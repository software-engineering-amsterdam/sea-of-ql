package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class FormText extends FormField {

	protected Expression calculation;
	
	public FormText(Identifier id, StringPrimitive label, Type type, Expression calculation) {
		super(id, label, type);
		this.calculation = calculation;
	}
	
	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
	
	public Expression getCalculation() {
		return calculation;
	}
}
