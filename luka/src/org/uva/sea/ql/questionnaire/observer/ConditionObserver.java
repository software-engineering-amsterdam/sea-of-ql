package org.uva.sea.ql.questionnaire.observer;

import java.util.Observable;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.State;
import org.uva.sea.ql.questionnaire.check.Evaluator;

public class ConditionObserver extends StatementObserver {
	
	private final State state;
	private final JPanel tru, fls;
	private final Expr cond;

	public ConditionObserver(Expr condition, State state, JPanel tru, JPanel fls) {
		super(state, condition);
		this.cond = condition;
		this.state = state;
		this.tru = tru;
		this.fls = fls;
	}

	@Override
	public void update(Observable o, Object arg) {
		Value value = cond.accept(new Evaluator(state.getEnv()));
		if (value.isDefined()) {
			boolean visible = ((Bool) value).getValue();
			tru.setVisible(visible);
			if (fls != null) {
				fls.setVisible(!visible);
			}
		} else {
			tru.setVisible(false);
			if (fls != null) {
				fls.setVisible(false);
			}

		}

	}

}
