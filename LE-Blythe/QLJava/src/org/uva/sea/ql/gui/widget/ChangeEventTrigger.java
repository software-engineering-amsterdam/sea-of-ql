package org.uva.sea.ql.gui.widget;

public interface ChangeEventTrigger {
	void addChangeEventListener(ChangeEventListener listener);
	void removeChangeEventListener(ChangeEventListener listener);
}
