package org.uva.sea.ql.renderer;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.evaluator.ExprEval;
import org.uva.sea.ql.evaluator.values.Value;

public class ComputedObserver implements Observer {
	
	private final Control contrl;
	private final State state;
	private final ComputedQuestion stat;
	
	public ComputedObserver(Control c, State s, ComputedQuestion q) {
		this.contrl = c;
		this.state = s;
		this.stat = q;
	}

	@Override
	public void update(Observable obs, Object arg) {
		Value val = stat.getExpression().accept(new ExprEval(state.getEnvironment()));
		state.putValue(stat.getIdentifier(), val);
		state.notify(stat.getIdentifier());
		contrl.setValue(val);
	}

}
