package org.uva.sea.ql.renderer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.evaluation.Evaluator;

public class ConditionObserver implements Observer {
	
	private final JPanel statementBody;
	private final Expr expr;
	private final State state;
	
	public ConditionObserver(JPanel statementBody, Expr expr, State state) {

		this.statementBody = statementBody;
		this.expr = expr;
		this.state = state;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		boolean v = (Boolean)Evaluator.eval(expr, state.getEnv()).getValue();
		
		statementBody.setVisible(v);
		
		System.out.println("update condition");
		
	}
	
}
