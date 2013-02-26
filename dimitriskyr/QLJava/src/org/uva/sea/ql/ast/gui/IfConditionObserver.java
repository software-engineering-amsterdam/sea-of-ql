package org.uva.sea.ql.ast.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.visitor.Evaluator;

public class IfConditionObserver implements Observer {

	private final Expr expression;
	private final JPanel tru;
	private JPanel fls;
	private final State state;

	public IfConditionObserver(Expr expression, JPanel tru, JPanel fls,
			State state) {
		this.expression = expression;
		this.tru = tru;
		this.fls = fls;
		this.state = state;
	}

	public IfConditionObserver(Expr condition, JPanel tru, State state) {
		this.expression = condition;
		this.tru = tru;
		this.state = state;
	}

	@Override
	public void update(Observable observable, Object arg) {
		// System.out.println(state.getEnv());
		Value value = (expression.accept(new Evaluator(state.getEnv())));
		// System.out.println(value);
		boolean visible = ((Bool) value).getValue();
		// System.out.println(visible);
		tru.setVisible(visible);
		if (fls != null)
			fls.setVisible(!visible);
	}

}
