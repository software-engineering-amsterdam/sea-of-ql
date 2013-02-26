package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.values.Evaluator;
import org.uva.sea.ql.ast.values.Value;

public class ComputedObserver implements Observer {
	
	private final Control control;
	private final State state;
	private final Computed stat;
	
	@Override
	public void update(Observable o, Object arg) {
		Value value = stat.getExpr().accept(new Evaluator(state.getEnv()));
		state.putValue(stat.getName(), value);
		state.notify(stat.getName());
		control.setValue(value);
	}
	
}
