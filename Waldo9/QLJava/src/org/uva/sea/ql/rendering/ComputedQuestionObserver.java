package org.uva.sea.ql.rendering;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.evaluation.ExprEvaluationVisitor;
import org.uva.sea.ql.evaluation.values.Value;

public class ComputedQuestionObserver implements Observer {

	private JComponent control;
	private State state;
	private ComputedQuestion computedQuestion;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Value value = computedQuestion.getExpression().accept(new ExprEvaluationVisitor(state.getIdentifierEnvironment()));
		state.putValue(computedQuestion.getVariable(), value);
		//state.notify(computedQuestion.getVariable());
		//control.
	}
	

}
