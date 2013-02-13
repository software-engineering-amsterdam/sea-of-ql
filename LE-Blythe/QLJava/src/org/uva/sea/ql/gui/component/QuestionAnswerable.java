package org.uva.sea.ql.gui.component;

import java.awt.Component;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.util.Environment;

public class QuestionAnswerable extends Question{

	private Component inputControl;
	
	public QuestionAnswerable(String question, Ident identifier, Component inputControl, Environment env) {
		super(question, identifier, env);
		this.inputControl = inputControl;
	}

	
}
