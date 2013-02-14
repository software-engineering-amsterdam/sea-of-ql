package org.uva.sea.ql.visitor.evaluator;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.visitor.evaluator.value.Value;

public class ComputedObserver implements Observer {
	private final Control component;
	private final Environment environment;
	private final ComputedQuestion question;

	public ComputedObserver( Control component, Environment environment, ComputedQuestion question ) {
		this.component = component;
		this.environment = environment;
		this.question = question;
	}

	@Override
	public void update( Observable observable, Object arg ) {
		Value value = Evaluator.evaluate( this.question.getExpression(), this.environment );

		this.environment.assign( question.getIdentifier(), value );
		this.environment.notifyObservers( this.question.getIdentifier() );

		this.component.setValue( value );
	}
}
