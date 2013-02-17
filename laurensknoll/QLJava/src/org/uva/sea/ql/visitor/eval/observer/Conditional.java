package org.uva.sea.ql.visitor.eval.observer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.Expression;
import org.uva.sea.ql.visitor.eval.value.Bool;

public class Conditional implements Observer {

	private final AbstractExpr condition;
	private final JPanel panel;
	private final Environment environment;

	public Conditional(AbstractExpr condition, JPanel panel, Environment context) {
		this.condition = condition;
		this.panel = panel;
		this.environment = context;
	}

	public void update() {
		Expression evaluator = new Expression(this.environment);
		Bool result = (Bool) this.condition.accept(evaluator);
		this.panel.setVisible(result.getValue());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.update();
	}

}
