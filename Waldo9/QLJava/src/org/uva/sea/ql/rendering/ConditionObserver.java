package org.uva.sea.ql.rendering;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.evaluation.ExprEvaluationVisitor;
import org.uva.sea.ql.evaluation.values.Bool;

public class ConditionObserver implements Observer {
	
	private final Expr condition;
	private final JPanel conditionTrue;
	private final JPanel conditionFalse;
	private final State state;

	public ConditionObserver(Expr condition, JPanel conditionTrue, JPanel conditionFalse, State state) {
		this.condition = condition;
		this.conditionTrue = conditionTrue;
		this.conditionFalse = conditionFalse;
		this.state = state;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		boolean value = ((Bool)condition.accept(new ExprEvaluationVisitor(state.getIdentifierEnvironment()))).getValue();
		conditionTrue.setVisible(value);
		conditionFalse.setVisible(value);
	}

}
