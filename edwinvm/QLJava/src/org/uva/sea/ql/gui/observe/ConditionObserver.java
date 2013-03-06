package org.uva.sea.ql.gui.observe;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.check.values.Evaluator;

public class ConditionObserver implements Observer {

	private final Expression _condition;
	private final ArrayList<JPanel> _renderedBody;
	private final ArrayList<JPanel> _renderedElseBody;
	private final State _state;
	
	public ConditionObserver(Expression condition, ArrayList<JPanel> renderedBody, State state) {
		this(condition, renderedBody, null, state);
	}
	
	public ConditionObserver(Expression condition, ArrayList<JPanel> renderedBody, ArrayList<JPanel> renderedElseBody, State state) {
		_condition = condition;
		_renderedBody = renderedBody;
		_renderedElseBody = renderedElseBody;
		_state = state;
	}

	@Override
	public void update(Observable o, Object arg) {
		Value value = evaluateExpression();
		boolean visible = ((Bool)value).getValue();
		setVisibilityFor(_renderedBody, visible);
		if (_renderedElseBody != null) {
			setVisibilityFor(_renderedElseBody, !visible);
		}
	}
	
	private void setVisibilityFor(ArrayList<JPanel> renderedBody, boolean visible) {
		for (JPanel panel: renderedBody) {
			panel.setVisible(visible);
		}
	}
	
	private Value evaluateExpression() {
		return Evaluator.evaluate(_condition, _state.getValueEnvironment());
	}

}