package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Ident;

/**
 * class: Question
 * @author Danny
 *
 */
public class Question extends FormElement {
	
	private final Ident identifier;
	private final String question;
	private final String type;
	
	/**
	 * Constructor
	 * @param id 	- Identifier
	 * @param q 	- Question
	 * @param t 	- Type
	 */
	public Question(Ident id, String q, String t) {
		super();
		this.identifier = id;
		this.question = q;
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
	 * getQuestion()
	 * @return question
	 */
	public String getQuestion(){
		return this.question;
	}
	/**
	 * getType()
	 * @return type
	 */
	public String getType(){
		return this.type;
	}
}
