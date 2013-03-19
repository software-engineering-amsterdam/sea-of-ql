package org.uva.sea.ql.renderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statement.Question;

public class QuestionObservable extends Observable implements ActionListener {
	
	private final Question question;
	private final State state;
	private final Control contrl;

	public QuestionObservable(Question stat, State state, Control contrl) {
		this.question = stat;
		this.state = state;
		this.contrl = contrl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		state.putValue(question.getIdentifier(), contrl.getValue());
		this.setChanged();
		this.notifyObservers();
		
	}

}
