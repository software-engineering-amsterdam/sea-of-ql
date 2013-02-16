package org.uva.sea.ql.ui;

import java.util.EventListener;

public interface ControlEventListener extends EventListener {
	void itemChanged( ControlEvent event );
}
