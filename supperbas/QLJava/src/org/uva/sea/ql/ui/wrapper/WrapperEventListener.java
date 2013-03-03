package org.uva.sea.ql.ui.wrapper;

import java.util.EventListener;

public interface WrapperEventListener extends EventListener {
	abstract void change(WrapperEvent event);
}
