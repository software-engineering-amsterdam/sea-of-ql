package org.uva.sea.ql.renderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.renderer.control.Control;

public class ObservableQuestion extends Observable implements ActionListener, FocusListener  {

	private final State state;
	private final Control ctrl;
	private final Question question;

	public ObservableQuestion(State state, Control ctrl, Question question) {
		this.state = state;
		this.ctrl = ctrl;
		this.question = question;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		state.putValue(question.getID().getName(), ctrl.getValue());
		setChanged();
		notifyObservers();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		state.putValue(question.getID().getName(), ctrl.getValue());
		setChanged();
		notifyObservers();

	}

}