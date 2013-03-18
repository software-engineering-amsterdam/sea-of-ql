package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.evaluator.ExprEvaluator;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.interpreter.controls.AControl;

public class ComputedObserver implements Observer {
	private final AControl ctrl;
	private final State state;
	private final ComputedQuestion stmt;
	
	public ComputedObserver(AControl ctrl, State state, ComputedQuestion stmt) {
		this.ctrl = ctrl;
		this.state = state;
		this.stmt = stmt;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		AValue value = stmt.getExpr().accept(new ExprEvaluator(state.getEnv()));
		state.putValue(stmt.getIdent(), value);
		state.notify(stmt.getIdent());
		ctrl.setValue(value);
	}
}