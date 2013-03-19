package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.evaluator.ExprEvaluator;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.evaluator.values.BoolValue;

public class ConditionObserver implements Observer {
	private final AExpr condition;
	private final JPanel ifPanel;
	private final JPanel elsePanel;
	private final State state;
	
	public ConditionObserver(AExpr condition, JPanel ifPanel, State state) {
		this.condition = condition;
		this.ifPanel = ifPanel;
		this.elsePanel = null;
		this.state = state;
	}
	
	public ConditionObserver(AExpr condition, JPanel ifPanel, JPanel elsePanel,State state) {
		this.condition = condition;
		this.ifPanel = ifPanel;
		this.elsePanel = elsePanel;
		this.state = state;
	}
		
	@Override
	public void update(Observable o, Object arg) {
		AValue value = condition.accept(new ExprEvaluator(state.getEnv()));
		boolean isVisible = ((BoolValue)value).getValue();
		ifPanel.setVisible(isVisible);
		if (elsePanel != null) {
			elsePanel.setVisible(!isVisible);
		}
	}
}