package org.uva.sea.ql.gui;

public interface ChangeEventTrigger {
	void addChangeEventListener(ChangeEventListener listener);
	void removeChangeEventListener(ChangeEventListener listener);
}
