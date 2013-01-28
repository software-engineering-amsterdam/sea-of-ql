package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.Expression;

public class IfStatement extends FormElement {
	Expression condition;
	List<FormElement> if_list;
	List<FormElement> else_list;

	public IfStatement(Expression condition, List<FormElement> if_list,
			List<FormElement> else_list) {
		// TODO Auto-generated constructor stub
	}
	
}
