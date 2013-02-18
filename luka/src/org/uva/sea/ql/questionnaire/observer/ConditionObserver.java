package org.uva.sea.ql.questionnaire.observer;

import java.util.Observable;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.check.Evaluator;
import org.uva.sea.ql.questionnaire.state.State;

public class ConditionObserver extends StatementObserver {
	private State state;
	private JPanel tru, fls;
	private Expr cond;

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
		}else{
			tru.setVisible(false);
			if (fls != null) {
				fls.setVisible(false);
			}
			
		}

	}

}
