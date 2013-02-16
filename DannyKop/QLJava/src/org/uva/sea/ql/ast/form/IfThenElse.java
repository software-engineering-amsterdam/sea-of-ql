package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.visitor.Visitor;

public class IfThenElse extends FormElement {

	private final Expr ifCon;
	private final List<FormElement> ifElements;
	private final List<FormElement> elseElements;
	
	/**
	 * Constructor
	 * @param ifCondition
	 * @param ifElements - elements
	 * @param elseCondition
	 * @param elseElements
	 */
	public IfThenElse(Expr ifCondition, List<FormElement> ifElements, List<FormElement> elseElements){
		super(new BoolType());
		this.ifCon = ifCondition;
		this.ifElements = ifElements;
		this.elseElements = elseElements;
	}
	/**
	 * getIfElements()
	 * @return ifElements
	 */
	public List<FormElement> getIfElements(){
		return this.ifElements;
	}
	/**
	 * getIf
	 * @return ifCon
	 */
	public Expr getIfExpr(){
		return this.ifCon;
	}
	/**
	 * getElseElements()
	 * @return elseElements
	 */
	public List<FormElement> getElseElements() {
		return this.elseElements;
	}
	/**
	 * accept()
	 * @param visitor
	 * @return type
	 */
	@Override
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
