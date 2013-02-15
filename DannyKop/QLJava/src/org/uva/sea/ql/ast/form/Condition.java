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
public class Condition extends FormElement {
	
	private final Expr ifCon;
	private final List<FormElement> ifElements;
	private final List<FormElement> elseElements;
	
	/**
	 * Constructor
	 * @param ifCondition
	 * @param e - elements
	 */
	public Condition(Expr ifCondition, List<FormElement> e){
		this(ifCondition, e, null);
	}
	/**
	 * Constructor
	 * @param ifCondition
	 * @param ifElements - elements
	 * @param elseCondition
	 * @param elseElements
	 */
	public Condition(Expr ifCondition, List<FormElement> ifElements, List<FormElement> elseElements){
		super(new BoolType());
		this.ifCon = ifCondition;
		this.ifElements = ifElements;
		this.elseElements = elseElements;
	}
		
	/**
	 * getElements()
	 * @return elements
	 */
	public List<FormElement> getIfElements(){
		return this.ifElements;
	}
	/**
	 * getIf
	 * @return ifCon
	 */
	public Expr getIf(){
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
	 * hasElse()
	 * @return boolean - true if elseElements has been set and not is null
	 */
	public boolean hasElse(){
		return (this.elseElements != null);
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
