package org.uva.sea.ql.evaluate.render;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ui.control.InputControl;
import org.uva.sea.ql.value.Value;

class ComputedObserver implements Observer {
	private final InputControl control;
	private final BindingEnvironment environment;
	private final ComputedQuestion question;

	public ComputedObserver( InputControl control, BindingEnvironment environment, ComputedQuestion question ) {
		this.control = control;
		this.environment = environment;
		this.question = question;
	}

	@Override
	public void update( Observable observable, Object arg ) {
		Value value = ExpressionEvaluator.evaluate( this.question.getExpression(), this.environment );

		this.environment.declare( question.getIdentifier(), value );
		this.environment.notifyObservers( this.question.getIdentifier() );

		this.control.setValue( value );
	}
}
