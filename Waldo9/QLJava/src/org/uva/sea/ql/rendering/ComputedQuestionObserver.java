package org.uva.sea.ql.rendering;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.evaluation.ExprEvaluationVisitor;
import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.rendering.controls.Control;

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
		Value value = computedQuestion.getExpression().accept(new ExprEvaluationVisitor(state.getIdentifierEnvironment()));
		state.putValue(computedQuestion.getVariable(), value);
		state.notify(computedQuestion.getVariable());
		control.setValue(value);
	}

}
