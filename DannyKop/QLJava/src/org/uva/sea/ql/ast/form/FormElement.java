package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Class: FormElement
 * @author Danny
 *
 */
public abstract class FormElement {
	
	private final Type type;
	
	/**
	 * Constructor
	 * @param t - Type of the element
	 */
	public FormElement(Type t){
		this.type = t;
	}
	/**
	 * getType
	 * @return type 
	 */
	public Type getType(){
		return this.type;
	}
	/**
	 * accept
	 * @param visitor
	 */
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
