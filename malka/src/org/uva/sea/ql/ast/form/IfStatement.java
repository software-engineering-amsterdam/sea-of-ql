package org.uva.sea.ql.ast.form;

import java.util.List;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.visitor.VisitorException;
import org.uva.sea.ql.visitor.Visitor;

public class IfStatement extends FormElement {
	BooleanExpression condition;
	List<FormElement> if_list;
	List<FormElement> else_list;

	public IfStatement(BooleanExpression condition, List<FormElement> if_list,
			List<FormElement> else_list) {
		this.condition = condition;
		this.if_list   = if_list;
		this.else_list = else_list;
	}
	
	public List<FormElement> getIfList() {
		return if_list;
	}
	
	public List<FormElement> getElseList() {
		return else_list;
	}
	
	@Override
	public void accept(Visitor visitor)
			throws VisitorException {
		visitor.visit(this);
	}

	public BooleanExpression getCondition() {
		return condition;
	}
}
