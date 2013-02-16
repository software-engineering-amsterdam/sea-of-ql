package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.visitor.Visitor;
/**
 * class: Condition
 * @author Danny
 *
 */
public class IfThen extends FormElement {
	
	private final Expr ifCon;
	private final List<FormElement> ifElements;
	
	/**
	 * Constructor
	 * @param ifCondition
	 * @param e - elements
	 */
	public IfThen(Expr ifCondition, List<FormElement> e){
		super(new BoolType());
		this.ifCon = ifCondition;
		this.ifElements = e;
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
	 * accept()
	 * @param visitor
	 * @return type
	 */
	@Override
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
