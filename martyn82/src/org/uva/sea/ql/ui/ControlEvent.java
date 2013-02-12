package org.uva.sea.ql.ui;

import org.uva.sea.ql.ui.control.Control;

public class ControlEvent {
	private final Control source;

	public ControlEvent( Control source ) {
		this.source = source;
	}

	public Control getSource() {
		return this.source;
	}
}
