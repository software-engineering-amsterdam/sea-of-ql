package org.uva.sea.ql.evaluator;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.evaluator.environment.ValueEnvironment;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.value.Value;

class ComputedObserver implements Observer {
	private final Control control;
	private final ValueEnvironment environment;
	private final ComputedQuestion question;

	public ComputedObserver( Control control, ValueEnvironment environment, ComputedQuestion question ) {
		this.control = control;
		this.environment = environment;
		this.question = question;
	}

	@Override
	public void update( Observable observable, Object arg ) {
		Value value = Evaluator.evaluate( this.question.getExpression(), this.environment );

		this.environment.assign( question.getIdentifier(), value );
		this.environment.notifyObservers( this.question.getIdentifier() );

		this.control.setValue( value );
	}
}
