package org.uva.sea.ql.observer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.form.IfConditionalExpr;
import org.uva.sea.ql.gui.State;
import org.uva.sea.ql.visitor.Eval;
import org.uva.sea.ql.visitor.Value;

public class ConditionObserver implements Observer {
	private final JPanel tru;
	private final JPanel fls;
	private final State state;
	private final IfConditionalExpr cond;

	public ConditionObserver(JPanel tru, JPanel fls, State state, IfConditionalExpr cond) {
		this.tru = tru;
		this.fls = fls;
		this.state = state;
		this.cond = cond;
		this.tru.setVisible(false);
		// this.fls.setVisible(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		Value value = cond.getOrexpr().accept(new Eval(state.getEnv()));
		boolean visible = value.isDefined() && ((Bool) value).getValue();
		tru.setVisible(visible);
		if (fls != null) {
			fls.setVisible(!visible);
		}
	}
}
