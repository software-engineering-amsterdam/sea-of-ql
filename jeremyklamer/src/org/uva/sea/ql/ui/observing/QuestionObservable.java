package org.uva.sea.ql.ui.observing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.ui.components.QuestionComponent;

public class QuestionObservable extends Observable implements ActionListener {

	private final Question question;
	private final Env env;
	private final QuestionComponent component;

	public QuestionObservable(Question question, Env env, QuestionComponent component) {
		this.question = question;
		this.env = env;
		this.component = component;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		env.putValue(question.getName(), component.getValue());
		setChanged();
		notifyObservers();			
	}	
	
}
