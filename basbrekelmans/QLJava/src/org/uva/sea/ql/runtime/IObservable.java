package org.uva.sea.ql.runtime;

public interface IObservable<T> {

	void addValueChangedListener(T listener);
	void removeValueChangedListener(T listener);
}
