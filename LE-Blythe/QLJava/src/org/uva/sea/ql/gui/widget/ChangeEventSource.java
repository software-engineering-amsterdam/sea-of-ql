package org.uva.sea.ql.gui.widget;

public interface ChangeEventSource {
	void addChangeEventListener(ChangeEventListener listener);
	void removeChangeEventListener(ChangeEventListener listener);
}
