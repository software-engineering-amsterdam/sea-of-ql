package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.*;
/**
 * class: Condition
 * @author Danny
 *
 */
public class Condition extends FormElement {
	
	private final Expr ifCon;
	private final List<FormElement> ifElements;
	
	/**
	 * Constructor
	 * @param ifCondition
	 * @param e - elements
	 */
	public Condition(Expr ifCondition, List<FormElement> e){
		super(ifCondition);
		this.ifCon = ifCondition;
		this.ifElements = e;
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
	 * accept()
	 * @param visitor
	 * @return type
	 */
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	/**
	 * getType
	 * @param st - the table to check for the type
	 * @return Expr - type
	 */
	@Override
	public Expr getType(SymbolTable st) {
		return ifCon.getType(st);
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return t.isCompatibleTo(this);
	}
}
