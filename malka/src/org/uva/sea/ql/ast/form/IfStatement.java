package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.expression.Expression;

public class IfStatement implements IFormElement {
	Expression condition;
	List<IFormElement> if_list;
	List<IFormElement> else_list;

	public IfStatement(Expression condition, List<IFormElement> if_list,
			List<IFormElement> else_list) {
		// TODO Auto-generated constructor stub
	}
	
}
