package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.visitor.*;
/**
 * Class: Computation
 * @author Danny
 *
 */
public class Computation extends FormElement {

	private final Ident identifier;
	private final Str description;
	private final Expr argument;

	/**
	 * Constructor
	 * @param id - identifier
	 * @param d  - description
	 * @param e  - argument
	 */
	public Computation(Ident id, Str d, Expr arg, Expr type) {
		super(type);
		this.identifier = id;
		this.description = d;
		this.argument = arg;
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
	public Str getDescription(){
		return this.description;
	}
	/**
	 * getExpr
	 * @return expr
	 */
	public Expr getArgument(){
		return this.argument;
	}
	/**
	 * getType
	 * @param st - the table to check for the type
	 * @return Expr - type
	 */
	@Override
	public Expr getType(SymbolTable st){
		return super.getType(st);
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
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return this.argument.isCompatibleTo(t);
	}
	
}
