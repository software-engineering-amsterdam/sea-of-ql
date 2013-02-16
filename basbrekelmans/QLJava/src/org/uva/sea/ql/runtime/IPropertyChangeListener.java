package org.uva.sea.ql.runtime;

public interface IPropertyChangeListener<TValue> {
	void onValueChanged(TValue value);
}
