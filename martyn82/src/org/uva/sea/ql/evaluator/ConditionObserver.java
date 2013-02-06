package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.Observable;
import org.uva.sea.ql.Observer;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.evaluator.value.Boolean;
import org.uva.sea.ql.evaluator.value.Value;
import org.uva.sea.ql.ui.control.Control;

public class ConditionObserver implements Observer {
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
	public void update( Observable observable ) {
		Value value = this.condition.accept( new Evaluator( this.environment ) );
		boolean visible = ( (Boolean) value ).getValue();

		this.trueComponent.setVisible( visible );

		if ( this.falseComponent != null ) {
			this.falseComponent.setVisible( !visible );
		}
	}
}
