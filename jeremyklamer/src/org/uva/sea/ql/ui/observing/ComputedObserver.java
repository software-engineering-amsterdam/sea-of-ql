package org.uva.sea.ql.ui.observing;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;

public class ComputedObserver implements Observer {

	private final ComputedQuestion computedQuestion;
	private final ActiveComponent component;
	private final Env env;
	
	public ComputedObserver(ComputedQuestion computedQuestion, ActiveComponent component, Env env ) {
		this.computedQuestion = computedQuestion;
		this.component = component;
		this.env = env;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Value value = computedQuestion.getComputation().eval(env);
		env.putValue(computedQuestion.getName(), value);
		env.notify(computedQuestion.getName());
		component.updateValue(value);
	}
	
}
