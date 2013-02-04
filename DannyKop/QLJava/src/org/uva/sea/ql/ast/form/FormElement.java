package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: FormElement
 * @author Danny
 *
 */
public abstract class FormElement extends Expr {
	
	private Expr type;
	
	/**
	 * Constructor
	 * @param t : type of the formelement (Bool, Money, Int, etc)
	 */
	public FormElement(Expr t){
		this.type = t;
	}	
	/**
	 * getType
	 * @param st
	 * @return Type of the element
	 */
	@Override
	public Expr getType(SymbolTable st){
		return this.type;
	}
	
}
