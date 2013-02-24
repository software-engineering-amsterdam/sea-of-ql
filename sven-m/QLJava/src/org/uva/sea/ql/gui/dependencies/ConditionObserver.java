package org.uva.sea.ql.gui.dependencies;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.gui.State;
import org.uva.sea.ql.parser.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class ConditionObserver implements Observer {
	private final Expr condition;
	private final JPanel ifTrue;
	private final JPanel ifFalse;
	private final State state;
	
	public ConditionObserver(Expr condition, JPanel ifTrue, JPanel ifFalse,
			State state)
	{
		this.condition = condition;
		this.ifTrue = ifTrue;
		this.ifFalse = ifFalse;
		this.state = state;
	}
	
	public ConditionObserver(Expr condition, JPanel ifTrue, State state) {
		this.condition = condition;
		this.ifTrue = ifTrue;
		this.ifFalse = null;
		this.state = state;
	}
	
	private JPanel getIfTrue() {
		return ifTrue;
	}
	
	private JPanel getIfFalse() {
		return ifFalse;
	}
	
	private Expr getCondition() {
		return condition;
	}
	
	private State getState() {
		return state;
	}
	
	private void toggleBodyVisibility(Value value) {
		boolean showTrue = value.isDefined() && (Boolean)value.getValue();
		getIfTrue().setVisible(showTrue);
		
		if (getIfFalse() != null) {
			boolean showFalse = value.isDefined() && !(Boolean)value.getValue();
			getIfFalse().setVisible(showFalse);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		ExpressionEvaluator eval =
				new ExpressionEvaluator(getState().getSymbolTable());
		
		toggleBodyVisibility(getCondition().accept(eval));
	}

}
