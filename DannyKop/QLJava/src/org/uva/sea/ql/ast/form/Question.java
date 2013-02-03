package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.*;
import org.uva.sea.ql.ast.types.*;

/**
 * class: Question
 * @author Danny
 *
 */
public class Question extends FormElement {
	
	private final Ident identifier;
	private final Str question;
	
	/**
	 * Constructor
	 * @param id 	- Identifier
	 * @param q 	- Question
	 */
	public Question(Ident id, Str q, Expr type) {
		super(type);
		this.identifier = id;
		this.question = q;
	}
	/**
	 * getIdent()
	 * @return identifier
	 */
	public Ident getIdent(){
		return this.identifier;
	}
	/**
	 * getQuestion()
	 * @return question
	 */
	public Str getQuestion(){
		return this.question;
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
		return t.isCompatibleTo(this);
	}
}
