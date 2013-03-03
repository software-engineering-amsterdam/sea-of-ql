package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.values.Evaluator;

public class ConditionObserver implements Observer {

	private final Expr expr;
	private final JPanel tru;
	private final JPanel fls;
	private final State state;

	public ConditionObserver(Expr expr, JPanel tru, JPanel fls, State state) {
		this.expr = expr;
		this.tru = tru;
		this.fls = fls;
		this.state = state;
	}
	
	public ConditionObserver(Expr expr, JPanel ifBody, State state) {
		this.expr = expr;
		this.tru = ifBody;
		this.fls = null;
		this.state = state;
	}

	@Override
	public void update(Observable o, Object arg) {
		boolean value = (Boolean) expr.accept(new Evaluator(state.getEnv())).getValue();
		tru.setVisible(value);
		if(fls!=null) fls.setVisible(value);
	}
	
}