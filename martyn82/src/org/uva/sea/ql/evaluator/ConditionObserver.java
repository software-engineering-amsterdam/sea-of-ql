package org.uva.sea.ql.evaluator;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.evaluator.environment.ValueEnvironment;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;

class ConditionObserver implements Observer {
	private final Expression condition;
	private final ValueEnvironment environment;
	private final Control trueComponent;
	private final Control falseComponent;

	public ConditionObserver(
		Expression condition, ValueEnvironment environment, Control trueComponent, Control falseComponent
	) {
		this.condition = condition;
		this.environment = environment;
		this.trueComponent = trueComponent;
		this.falseComponent = falseComponent;
	}

	@Override
	public void update( Observable observable, Object arg ) {
		Value value = Evaluator.evaluate( this.condition, this.environment );
		boolean visible = ( (BooleanValue) value ).getValue();

		this.trueComponent.setVisible( visible );

		if ( this.falseComponent != null ) {
			this.falseComponent.setVisible( !visible );
		}
	}
}
