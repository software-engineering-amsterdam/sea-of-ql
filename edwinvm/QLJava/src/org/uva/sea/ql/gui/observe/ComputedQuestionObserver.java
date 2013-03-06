package org.uva.sea.ql.gui.observe;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.check.values.Evaluator;
import org.uva.sea.ql.gui.render.widgets.Widget;

public class ComputedQuestionObserver implements Observer {

	private final Widget _widget;
	private final State _state;
	private final ComputedQuestion _statement;

	public ComputedQuestionObserver(Widget widget, State state, ComputedQuestion statement) {
		_widget = widget;
		_state = state;
		_statement = statement;
	}

	@Override
	public void update(Observable o, Object arg) {
		Value value = evaluateExpression();
		storeValue(value);
		notifyObservers();
		updateGUIWith(value);
	}
	
	private Value evaluateExpression() {
		return Evaluator.evaluate(_statement.getExpression(), _state.getValueEnvironment());
	}
	
	private void storeValue(Value value) {
		_state.putValue(_statement.getQuestionVariable().getVariable(), value);
	}
	
	private void notifyObservers() {
		_state.notify(_statement.getQuestionVariable().getVariable());
	}
	
	private void updateGUIWith(Value value) {
		_widget.setValue(value);
	}

}