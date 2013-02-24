package org.uva.sea.ql.visitor.eval.observer;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.Expression;
import org.uva.sea.ql.visitor.eval.ui.Panel;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Bool;

public class Conditional implements Observer {

	private final AbstractExpr condition;
	private final Panel truePanel;
	private final Environment environment;

	public Conditional(AbstractExpr condition, Environment environment,
			Panel truePanel) {
		this.condition = condition;
		this.environment = environment;
		this.truePanel = truePanel;

		// Initially the condition is evaluated as false.
		this.truePanel.setVisible(false);
	}

	public void update() {
		IExpression<AbstractValue> evaluator = new Expression(this.environment);
		Bool result = (Bool) this.condition.accept(evaluator);
		this.truePanel.setVisible(result.getValue());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.update();
	}

}
