package org.uva.sea.ql.runtime;

import java.util.Observable;

public class ComputedVariable extends Variable {

	@Override
	public boolean isComputed() {
		return true;
	}

	@Override
	public void update(final Observable o, final Object arg) {
		this.valueSetter.update(o, arg);
	}

}
