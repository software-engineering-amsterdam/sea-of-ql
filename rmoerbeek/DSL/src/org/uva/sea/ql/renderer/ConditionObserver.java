package org.uva.sea.ql.renderer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.evaluator.ExprEval;
import org.uva.sea.ql.evaluator.values.BoolValue;
import org.uva.sea.ql.evaluator.values.Value;

public class ConditionObserver implements Observer {
	
	private final Expr condition;
	private final Expr ifElseCondition;
	private final JPanel ifPanel;
	private final JPanel elsePanel;
	private final State state;
	
	
	public ConditionObserver(Expr ifC, Expr ifElseC, JPanel ifPanel, JPanel elsePanel, State state) {
		this.condition = ifC;
		this.ifElseCondition = ifElseC;
		this.ifPanel = ifPanel;
		this.elsePanel = elsePanel;
		this.state = state;
	}
	
	public ConditionObserver(Expr c, JPanel ifPanel, State state) {
		this.condition = c;
		this.ifPanel = ifPanel;
		this.elsePanel = null;
		this.ifElseCondition = null;
		this.state = state;
	}

	public Expr getCondition() {
		return this.condition;
	}
	
	public Expr getIfElseCondition() {
		return this.ifElseCondition;
	}
	
	public JPanel getTruePanel() {
		return this.ifPanel;
	}
	
	public JPanel getFalsePanel() {
		return this.elsePanel;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Value val = condition.accept(new ExprEval(state.getEnvironment()));
		boolean visibility = ((BoolValue) val).getValue();
		ifPanel.setVisible(visibility); 	// depending of the evaluation of the condition,
		if (!(visibility) && elsePanel != null) {
			Value valElse = ifElseCondition.accept(new ExprEval(state.getEnvironment()));
			boolean visibilityElsePanel = ((BoolValue) valElse).getValue();
			elsePanel.setVisible(visibilityElsePanel);	// show if-panel or else-panel
		}
	
	}

}
