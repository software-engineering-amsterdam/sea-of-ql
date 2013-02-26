package org.uva.sea.ql.gui.propagation;

import java.util.Observable;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.gui.misc.InputSource;
import org.uva.sea.ql.gui.misc.InputSourceDelegate;
import org.uva.sea.ql.gui.misc.ValueState;

public class ObservableQuestion extends Observable implements
		InputSourceDelegate
{
	private final Question question;
	private final ValueState state;

	public ObservableQuestion(Question question, ValueState state,
			InputSource source)
	{
		this.question = question;
		this.state = state;

		source.setDelegate(this);
	}
	
	private Question getQuestion() {
		return question;
	}

	private ValueState getState() {
		return state;
	}

	@Override
	public void valueChanged(InputSource source) {
		setChanged();
		getState().putValue(getQuestion().getIdent(), source.getValue());
		notifyObservers();
		clearChanged();
	}

}
