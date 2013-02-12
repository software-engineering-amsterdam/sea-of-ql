package org.uva.sea.ql.gui.component;

import java.awt.Label;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.util.Environment;

public abstract class Question extends Statement {

	private static final long serialVersionUID = 1L;

	protected Ident identifier;
	
	public Question(String question, Ident identifier,Environment env) {
		super(env);
		
		this.add(new Label(question));	
		this.identifier = identifier;
	}

	@Override
	public boolean evaluateVisibility() {
		return true;
	}

}
