package org.uva.sea.ql.ui.observing;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.ui.components.QuestionComponent;

public class QuestionObservable extends Observable implements FocusListener {

	private final Question question;
	private final Env env;
	private final QuestionComponent component;

	public QuestionObservable(Question question, Env env, QuestionComponent component) {
		this.question = question;
		this.env = env;
		this.component = component;
	}

	@Override
	public void focusGained(FocusEvent arg0) {	
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		//TODO remove double dots
		env.putValue(question.getName(), component.getValue());
		setChanged();
		notifyObservers();		
	}	
	
}
