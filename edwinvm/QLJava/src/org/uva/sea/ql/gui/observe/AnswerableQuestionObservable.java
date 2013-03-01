package org.uva.sea.ql.gui.observe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statements.questions.Question;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.check.values.Evaluator;
import org.uva.sea.ql.gui.render.widgets.Widget;

public class AnswerableQuestionObservable extends Observable implements FocusListener, ActionListener {

	private final Widget _widget;
	private final State _state;
	private final Question _statement;

	public AnswerableQuestionObservable(Widget widget, State state, Question statement) {
		_widget = widget;
		_state = state;
		_statement = statement;
	}
	
	private Value evaluateInput() {
		return Evaluator.evaluate(_widget.getValue(), _state.getValueEnvironment());
	}
	
	private void storeValue(Value value) {
		_state.putValue(_statement.getQuestionVariable().getVariable(), value);
	}
	
	@Override
	public void focusGained(FocusEvent arg0)      { }
	@Override
	public void focusLost(FocusEvent arg0)        { update(); }
	@Override
	public void actionPerformed(ActionEvent arg0) { update(); }
	
	private void update() {
		storeValue(evaluateInput());
		setChanged();
		notifyObservers();
	}

}