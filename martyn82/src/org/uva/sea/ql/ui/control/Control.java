package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.value.Value;

abstract public class Control {
	abstract public Object getInnerControl();
	abstract public void setEnabled( boolean enabled );
	abstract public void setVisible( boolean visible );
	abstract public void setValue( Value value );
	abstract public Value getValue();
	abstract public void addChangeListener( final ControlEventListener listener );
}
