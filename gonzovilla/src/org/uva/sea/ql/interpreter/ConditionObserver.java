package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.values.Value;

public class ConditionObserver implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		Value value = cond.accept(new Eval(state.getEnv()));
		boolean visible = value.isDefined() && ((Bool)value).getValue();
		tru.setVisible(visible);
		if (fls != null) {
			fls.setVisible(!visible);
		}
	}

}