package org.uva.sea.ql.ast.gui;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.visitor.Evaluator;

public class ComputedObserver implements Observer {

	private final Control control;
	private final State state;
	private final QuestionElement comQuestion;

	public ComputedObserver(Control control, State state,
			QuestionElement question) {
		this.control = control;
		this.state = state;
		this.comQuestion = question;
	}

	public Control getControl() {
		return control;
	}

	public QuestionElement getComQuestion() {
		return comQuestion;
	}

	public State getState() {
		return state;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(comQuestion.getExpression());
		Value value = comQuestion.getExpression().accept(
				new Evaluator(state.getEnv()));
		state.putValue(comQuestion.getIdent().getValue(), value);
		state.notify(comQuestion.getIdent());
		getControl().setValueOfComponent(value);
	}
}
