package org.uva.sea.ql.observer;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.form.Calculation;
import org.uva.sea.ql.gui.State;
import org.uva.sea.ql.visitor.Eval;
import org.uva.sea.ql.visitor.Value;

public class ComputedObserver implements Observer {

	private final Control control;
	private final State state;
	private final Calculation stat;

	public ComputedObserver(Control control, State state, Calculation stat) {
		this.control = control;
		this.state = state;
		this.stat = stat;
	}

	@Override
	public void update(Observable o, Object arg) {
		Value value = stat.getOrexpr().accept(new Eval(state.getEnv()));
		state.addEnv(stat.getIdent(), value);
		state.notify(stat.getIdent());
		control.setValue(value);
	}
}
