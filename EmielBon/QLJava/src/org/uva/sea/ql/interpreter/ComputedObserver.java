package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.eval.*;
import org.uva.sea.ql.gui.controls.Control;

public class ComputedObserver implements Observer {

	private final Control control;
	private final State state;
	private final ComputedQuestion stat;
	
	public ComputedObserver(Control control, State state, ComputedQuestion stat) {
		this.control = control;
		this.state = state;
		this.stat = stat;
	}
	
	public void update(Observable o, Object arg) {
		try {
			Value value = stat.getExpression().accept(new Eval(state.getEnvironment()));
			state.putValue(stat.getIdentifier(), value);
			state.notify(stat.getIdentifier());
			control.setValue(value);
		} catch (UnsupportedOperationException e) {
			
		}
	}

}