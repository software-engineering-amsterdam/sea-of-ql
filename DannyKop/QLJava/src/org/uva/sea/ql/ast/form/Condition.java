package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;

public class Condition extends FormElement {
	
	private final Expr ifCon;
	private final Expr elseCon;
	
	/**
	 * Constructor
	 * @param ifCondition
	 */
	public Condition(Expr ifCondition){
		this(ifCondition, null);
	}
	/**
	 * Constructor
	 * @param ifCondition
	 * @param elseCondition
	 */
	public Condition(Expr ifCondition, Expr elseCondition) {
		super();
		this.ifCon = ifCondition;
		this.elseCon = elseCondition;
	}
}
