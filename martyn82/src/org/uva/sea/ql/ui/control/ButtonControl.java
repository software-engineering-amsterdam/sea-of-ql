package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.ui.ControlEventListener;

abstract public class ButtonControl extends Control {
	abstract public void addClickListener( final ControlEventListener listener );
}
