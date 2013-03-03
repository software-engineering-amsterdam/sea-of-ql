package org.uva.sea.ql.gui.observe;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.check.values.Evaluator;

public class ConditionObserver implements Observer {

	private final Expression _condition;
	private final JPanel _renderedBody;
	private final JPanel _renderedElseBody;
	private final State _state;
	
	public ConditionObserver(Expression condition, JPanel renderedBody, State state) {
		this(condition, renderedBody, null, state);
	}
	
	public ConditionObserver(Expression condition, JPanel renderedBody, JPanel renderedElseBody, State state) {
		_condition = condition;
		_renderedBody = renderedBody;
		_renderedElseBody = renderedElseBody;
		_state = state;
	}

	@Override
	public void update(Observable o, Object arg) {
		Value value = evaluateExpression();
		boolean visible = ((Bool)value).getValue();
		_renderedBody.setVisible(visible);
		if (_renderedElseBody != null) {
			_renderedElseBody.setVisible(!visible);
		}
	}
	
	private Value evaluateExpression() {
		return Evaluator.evaluate(_condition, _state.getValueEnvironment());
	}

}