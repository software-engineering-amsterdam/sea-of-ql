package org.uva.sea.ql.observers;

import java.util.EventObject;
import java.util.Observable;

import org.uva.sea.ql.gui.ChangeEventListener;
import org.uva.sea.ql.gui.ChangeEventTrigger;

public class AnswerableObservable extends Observable implements ChangeEventListener {
	
	public AnswerableObservable(ChangeEventTrigger component){
		component.addChangeEventListener(this);
	}

	@Override
	public void onChange(EventObject e) {
		setChanged();
		notifyObservers();
	}
}
