package org.uva.sea.ql.visitors;

import java.util.LinkedList;
import java.util.List;

public class Observable {
	private final List<Observer> observers;

	public Observable() {
		observers = new LinkedList<Observer>();
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}
