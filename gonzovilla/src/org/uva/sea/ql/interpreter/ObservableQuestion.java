package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;

import org.uva.sea.ql.ast.stat.Question;

public class ObservableQuestion extends Observable implements ActionListener, FocusListener{

	private final Question question;
	private final State state;
	private final Control control;

	public ObservableQuestion(Question question, State state, Control control) {
		this.question = question;
		this.state = state;
		this.control = control;
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		state.putValue(question.getIdent().getName(), control.getValue());
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		state.putValue(question.getIdent().getName(), control.getValue());
		setChanged();
		notifyObservers();
	}

}
