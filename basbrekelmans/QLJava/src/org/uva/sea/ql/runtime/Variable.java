package org.uva.sea.ql.runtime;

import java.util.ArrayList;

public abstract class Variable {
	
	public abstract <T> T getValue();
	private ArrayList<IValueChangedListener> _listeners = new ArrayList<IValueChangedListener>();
	
	public void AddHandler(IValueChangedListener observer) {
		_listeners.add(observer);
	}
	public void RemoveHandler(IValueChangedListener observer) {
		if (_listeners.contains(observer)) {
			_listeners.remove(observer);
		}
	}
	
}
