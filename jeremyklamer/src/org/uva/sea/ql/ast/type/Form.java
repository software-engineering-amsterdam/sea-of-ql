package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Ident;

public class Form extends Type{
	
	private final Questions questions; 
	private final Ident ident; 
	
	public Form(Ident ident, Questions questions){
		this.ident = ident;
		this.questions = questions;
	}

	public Ident getIdent() {
		return ident;
	}

	public Questions getQuestions() {
		return questions;
	}

}
