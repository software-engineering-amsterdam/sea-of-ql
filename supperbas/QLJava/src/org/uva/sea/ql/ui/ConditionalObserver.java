package org.uva.sea.ql.ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.ExpressionEvaluator;


public class ConditionalObserver implements Observer  {
	private final JPanel tru;
	private final JPanel fls;
	private final Environment environment;
	private final If ifExpr;

	public ConditionalObserver(JPanel tru, JPanel fls, Environment environment, If ifExpr) {
		this.tru = tru;
		this.fls = fls;
		this.environment = environment;
		this.ifExpr = ifExpr;
	}

	public void update(Observable observable, Object arg) {
		Bool value = (Bool) ifExpr.getCondition().accept(new ExpressionEvaluator(environment));
		boolean visible = value.isDefined() && value.getValue();
		tru.setVisible(visible);
		fls.setVisible(!visible);
	}

}
