package org.uva.sea.ql.gui.dependencies;

import java.util.Observable;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.gui.InputSourceDelegate;
import org.uva.sea.ql.gui.State;
import org.uva.sea.ql.gui.InputSource;

public class ObservableQuestion extends Observable implements InputSourceDelegate {

	private final Question question;
	private final State state;
	private final InputSource source;
	
	public ObservableQuestion(Question question, State state, InputSource source) {
		this.question = question;
		this.state = state;
		this.source = source;
		
		this.source.setDelegate(this);
	}
	
	@Override
	public void valueChanged(InputSource source) {
		setChanged();
		state.putValue(question.getIdent(), source.getValue());
		notifyObservers();
		clearChanged();
	}

	
	
	
}
