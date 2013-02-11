package org.uva.sea.ql.visitor.evaluator;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.visitor.evaluator.value.Value;

public class ComputedObserver implements Observer {
	private final Control component;
	private final Environment environment;
	private final QuestionComputed question;

	public ComputedObserver( Control component, Environment environment, QuestionComputed question ) {
		this.component = component;
		this.environment = environment;
		this.question = question;
	}

	@Override
	public void update( Observable observable, Object arg ) {
		Value value = Evaluator.evaluate( this.question.getExpression(), this.environment );
		this.environment.assign( question.getIdent(), value );
		this.environment.notifyObservers( this.question.getIdent() );
		this.component.setValue( value.getValue() );
	}
}
