package org.uva.sea.ql.visitors;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.Value;

public class ConditionObserver implements Observer {

	private final Expr condition;
	private final State env;
	private final JPanel thenBody;
	private final JPanel elseBody;

	public ConditionObserver(Expr condition, State env, JPanel thenBody, JPanel elseBody) {
		this.condition = condition;
		this.env = env;
		this.thenBody = thenBody;
		this.elseBody = elseBody;
	}

	@Override
	public void update(Observable observable) {
		Value value = condition.accept(new ExprEvaluator(env.getEnv()));
		boolean visible = ((BoolLiteral) value).getValue();
		thenBody.setVisible(visible);
		if (elseBody != null) {
			elseBody.setVisible(!visible);
		}
	}

}
