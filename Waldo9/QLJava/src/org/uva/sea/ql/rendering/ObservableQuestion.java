package org.uva.sea.ql.rendering;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.rendering.controls.Control;

public class ObservableQuestion extends Observable implements FocusListener, ActionListener {

	private final Question question;
	private final State state;
	private final Control control;
	
	public ObservableQuestion(Question question, State state, Control control) {
		this.question = question;
		this.state = state;
		this.control = control;
	}

	@Override
	public void focusGained(FocusEvent arg0) {		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		updateValueAndNotify();		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		updateValueAndNotify();		
	}
	
	private void updateValueAndNotify() {
		state.putValue(question.getVariable(), control.getValue());
		setChanged();
		notifyObservers();
	}

}
