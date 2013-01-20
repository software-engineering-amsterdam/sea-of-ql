package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;

public class Computation extends FormElement {

	private final Ident identifier;
	private final String description;
	private final Expr expr;
	private final String type;
	/**
	 * Constructor
	 * @param id - identifier
	 * @param d  - description
	 * @param e  - expr
	 * @param t  - type 
	 */
	public Computation(Ident id, String d, Expr e, String t) {
		this.identifier = id;
		this.description = d;
		this.expr = e;
		this.type = t;
	}
	/**
	 * getIdent()
	 * @return identifier
	 */
	public Ident getIdent(){
		return this.identifier;
	}
	/**
	 * getDescription()
	 * @return question
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * getType()
	 * @return type
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * getExpr
	 * @return expr
	 */
	public Expr getExpr(){
		return this.expr;
	}
	
}
