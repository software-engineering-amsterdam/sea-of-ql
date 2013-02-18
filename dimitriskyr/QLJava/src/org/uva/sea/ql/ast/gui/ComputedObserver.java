package org.uva.sea.ql.ast.gui;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.visitor.Evaluator;

public class ComputedObserver implements Observer {

	private final Control control;
	private final State state;
	private final ComQuestion comQuestion;
	
	@Override
	public void update(Observable o, Object arg) {
		Value value = comQuestion.getExpression().accept(new Evaluator(state.getEnv()));
		state.putValue(comQuestion.getIdent(), value);
		state.notify(comQuestion.getIdent());
		control.setValue(value);
	}

}
