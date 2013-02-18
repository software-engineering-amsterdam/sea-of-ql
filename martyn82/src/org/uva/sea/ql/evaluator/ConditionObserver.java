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
	private final Control trueControl;
	private final Control falseControl;

	public ConditionObserver(
		Expression condition, ValueEnvironment environment, Control trueControl, Control falseControl
	) {
		this.condition = condition;
		this.environment = environment;
		this.trueControl = trueControl;
		this.falseControl = falseControl;
	}

	@Override
	public void update( Observable observable, Object arg ) {
		Value value = Evaluator.evaluate( this.condition, this.environment );
		boolean visible = ( (BooleanValue) value ).getValue();

		this.trueControl.setVisible( visible );

		if ( this.falseControl != null ) {
			this.falseControl.setVisible( !visible );
		}
	}
}
