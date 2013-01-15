package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.base.Expression;

public class Form extends Expression {
	private List<Element> expressions;
	
	public Form(List<Element> expressions) {
		this.expressions = expressions;
	}
}
