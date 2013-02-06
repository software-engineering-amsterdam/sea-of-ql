package org.uva.sea.ql.ast.form;

public abstract class AbstractIfThenElse extends FormElement {
	private final Body body;
	
	public AbstractIfThenElse(Body body) {
		this.body = body;
	}
	
	public Body getBody() {
		return body;
	}
	
}
