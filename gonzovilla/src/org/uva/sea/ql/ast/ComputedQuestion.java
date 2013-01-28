package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.Type;

public class ComputedQuestion extends FormUnit {

	private String name;
	private String body;
	private Type type;
	private Expr condition;
	
	public ComputedQuestion(String name, String body, Expr condition, Type type) {
		this.name = name;
		this.body = body;
		this.type = type;
		this.condition = condition;
	}

	public String getName() {
		return name;
	}

	public String getBody() {
		return body;
	}
	
	public Expr getCondition() {
		return condition;
	}

	public Type getType() {
		return type;
	}

}
