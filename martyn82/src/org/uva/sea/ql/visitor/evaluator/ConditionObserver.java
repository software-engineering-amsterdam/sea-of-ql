package org.uva.sea.ql.visitor.evaluator;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.visitor.evaluator.value.BooleanValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

class ConditionObserver implements Observer {
	private final Expression condition;
	private final Environment environment;
	private final Control trueComponent;
	private final Control falseComponent;

	public ConditionObserver( Expression condition, Environment environment, Control trueComponent, Control falseComponent ) {
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
