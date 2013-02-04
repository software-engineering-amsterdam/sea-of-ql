package org.uva.sea.ql;

import java.util.LinkedList;
import java.util.List;

public class Observable {
	private final List<Observer> observers;

	public Observable() {
		this.observers = new LinkedList<Observer>();
	}

	public void registerObserver( Observer observer ) {
		this.observers.add( observer );
	}

	public int countObservers() {
		return this.observers.size();
	}

	public void notifyObservers() {
		for ( Observer observer : this.observers ) {
			observer.update( this );
		}
	}
}
