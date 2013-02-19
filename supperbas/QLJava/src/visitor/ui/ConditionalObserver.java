package visitor.ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import visitor.Environment;
import visitor.evaluator.ExpressionEvaluator;
import ast.statement.If;

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
		boolean cond = ifExpr.getCondition().accept(new ExpressionEvaluator(environment));
		tru.setVisible(cond);
		fls.setVisible(!cond);
		
	}

}
