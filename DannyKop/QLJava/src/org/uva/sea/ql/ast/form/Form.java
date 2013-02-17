package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.visitor.Visitor;

/**
 * class: Form
 * @author Danny
 *
 */
public class Form implements ASTNode {
	
	private final Ident identifier;
	private final List<FormElement> elements;
	
	/**
	 * Constructor
	 * @param id 	- identifier
	 * @param stats - elements of the form 
	 */
	public Form(Ident id, List<FormElement> elem) {
		this.identifier = id;
		this.elements = elem;	
	}
	/**
	 * getIdent()
	 * @return Ident
	 */
	public Ident getIdent(){
		return this.identifier;
	}
	/**
	 * getStatement()
	 * @return statements
	 */
	public List<FormElement> getElements(){
		return this.elements;
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
