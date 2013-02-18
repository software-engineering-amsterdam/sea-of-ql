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
	private final JPanel truePanel;
	private final Environment environment;

	public Conditional(AbstractExpr condition, JPanel truePanel, Environment environment) {
		this.condition = condition;
		this.truePanel = truePanel;
		this.environment = environment;
	}

	public void update() {
		Expression evaluator = new Expression(this.environment);
		Bool result = (Bool) this.condition.accept(evaluator);
		this.truePanel.setVisible(result.getValue());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.update();
	}

}
