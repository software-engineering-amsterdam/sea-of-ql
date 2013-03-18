package org.uva.sea.ql.ast.form;

import java.util.Observable;

import org.uva.sea.ql.visitor.IForm;

public abstract class ObservableStatement extends Observable implements IForm {

	public void notifyObs() {
		setChanged();
		notifyObservers();
	}

}
