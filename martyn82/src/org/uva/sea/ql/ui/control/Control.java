package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.ui.ControlEventListener;

abstract public class Control {
	abstract public Object getControl();

	abstract public void setEnabled( boolean enabled );
	abstract public void setVisible( boolean visible );
	abstract public void setValue( Object value );
	abstract public Object getValue();
	abstract public void addChangeListener( final ControlEventListener listener );
}
