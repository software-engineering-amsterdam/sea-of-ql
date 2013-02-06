package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.Observable;
import org.uva.sea.ql.Observer;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.evaluator.value.Value;
import org.uva.sea.ql.ui.control.Control;

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
	public void update( Observable observable ) {
		Value value = this.question.getExpression().accept( new Evaluator( this.environment ) );
		this.environment.assign( question.getIdent(), value );
		this.environment.notifyObservers( this.question.getIdent() );
		this.component.setValue( value.getValue() );
	}
}
