package org.uva.sea.ql.ast.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statements.QuestionElement;

public class ObservableQuestion extends Observable implements FocusListener,
		ActionListener {

	QuestionElement question;
	State state;
	Control control;

	public ObservableQuestion(QuestionElement question, State state,
			Control control) {
		this.question = question;
		this.state = state;
		this.control = control;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		state.putValue(question.getIdent().getValue(), control.getValue());
		setChanged();
		notifyObservers();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		state.putValue(question.getIdent().getValue(), control.getValue());
		System.out.println(question.getIdent().getValue());
		setChanged();
		notifyObservers();
	}

}
