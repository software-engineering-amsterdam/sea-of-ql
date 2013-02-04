package org.uva.sea.ql.evaluator;

import javax.swing.JComponent;

import org.uva.sea.ql.Observable;
import org.uva.sea.ql.Observer;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.evaluator.value.Boolean;
import org.uva.sea.ql.evaluator.value.Value;

public class ConditionObserver implements Observer {
	private final Expression condition;
	private final Environment environment;
	private final JComponent trueComponent;
	private final JComponent falseComponent;

	public ConditionObserver( Expression condition, Environment environment, JComponent trueComponent, JComponent falseComponent ) {
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
