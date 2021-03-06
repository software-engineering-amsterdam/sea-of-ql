package org.uva.sea.ql.gui.propagation;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.gui.misc.ValueState;
import org.uva.sea.ql.parser.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class ConditionObserver implements Observer {
	private final Expr condition;
	private final JPanel ifTrue;
	private final JPanel ifFalse;
	private final ValueState state;

	public ConditionObserver(Expr condition, JPanel ifTrue, JPanel ifFalse,
			ValueState state)
	{
		this.condition = condition;
		this.ifTrue = ifTrue;
		this.ifFalse = ifFalse;
		this.state = state;
	}

	public ConditionObserver(Expr condition, JPanel ifTrue, ValueState state) {
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

	private ValueState getState() {
		return state;
	}

	private void toggleBodyVisibility(Value value) {
		boolean showTrue = value.isDefined() && (Boolean) value.getValue();
		getIfTrue().setVisible(showTrue);

		if (getIfFalse() != null) {
			boolean showFalse = value.isDefined()
					&& !(Boolean) value.getValue();
			getIfFalse().setVisible(showFalse);
		}
	}

	/* Observer */
	
	@Override
	public void update(Observable o, Object arg) {
		ExpressionEvaluator eval = new ExpressionEvaluator(
				getState().getSymbolTable());

		toggleBodyVisibility(getCondition().accept(eval));
	}

}
