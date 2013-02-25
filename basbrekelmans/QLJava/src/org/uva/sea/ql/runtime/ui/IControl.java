package org.uva.sea.ql.runtime.ui;

public interface IControl {
	abstract Object getUnderlyingComponent();

	abstract boolean isEnabled();

	abstract void setEnabled(boolean value);

}
