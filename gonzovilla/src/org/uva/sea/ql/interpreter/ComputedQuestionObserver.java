package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.values.Evaluator;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.interpreter.Control;

public class ComputedQuestionObserver implements Observer {

	private final Control control;
	private final State state;
	private final ComputedQuestion computedQuestion;

	public ComputedQuestionObserver(Control control, State state, ComputedQuestion computedQuestion) {
		this.control = control;
		this.state = state;
		this.computedQuestion = computedQuestion;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Value value = computedQuestion.getExpression().accept(new Evaluator(state.getEnv()));
		state.putValue(computedQuestion.getIdent().getName(), value);
		state.notifyObservers(computedQuestion.getIdent().getName());
		control.setValue(value);
	}

}