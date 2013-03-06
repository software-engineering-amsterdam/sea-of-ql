package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.eval.*;

/*public class ComputedObserver implements Observer {

	private final Control control;
	private final State state;
	private final ComputedQuestion stat;
	
	public void update(Observable o, Object arg) {
		Value value = stat.getExpression().accept(new Eval(state.getEnvironment()));
		state.putValue(stat.getIdentifier(), value);
		//state.notify(stat.getIdentifier());
		control.setValue(value);
	}

}*/
