package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.literals.StrLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.Visitor;
/**
 * Class: Computation
 * @author Danny
 *
 */
public class Computation extends FormElement {

	private final Ident identifier;
	private final StrLiteral description;
	private final Expr argument;

	/**
	 * Constructor
	 * @param id - identifier
	 * @param d  - description
	 * @param e  - argument
	 */
	public Computation(Ident id, StrLiteral d, Expr arg, Type type) {
		super(type);
		this.identifier = id;
		this.description = d;
		this.argument = arg;
	}
	/**
	 * getIdentifier
	 * @return identifier
	 */
	public Ident getIdentifier(){
		return this.identifier;
	}
	/**
	 * getDescription()
	 * @return question
	 */
	public StrLiteral getDescription(){
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
	 * accept()
	 * @param visitor
	 * @return type
	 */
	@Override
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
