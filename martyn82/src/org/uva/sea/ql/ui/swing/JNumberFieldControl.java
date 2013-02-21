package org.uva.sea.ql.ui.swing;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.InputControlEventListener;
import org.uva.sea.ql.ui.control.NumberFieldControl;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;

public class JNumberFieldControl extends NumberFieldControl {
	private final JSpinner control;

	public JNumberFieldControl() {
		this.control = new JSpinner( new SpinnerNumberModel() );
	}

	@Override
	public JSpinner getInnerControl() {
		return this.control;
	}

	@Override
	public void setValue( Value value ) {
		this.control.setValue( value.getValue() );
	}

	@Override
	public void setEnabled( boolean enabled ) {
		this.control.setEnabled( enabled );
	}

	@Override
	public void setVisible( boolean visible ) {
		this.control.setVisible( visible );
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue( Integer.parseInt( this.control.getValue().toString() ) );
	}

	@Override
	public void addChangeListener( final InputControlEventListener listener ) {
		this.control.addChangeListener(
			new ChangeListener() {
				@Override
				public void stateChanged( ChangeEvent arg0 ) {
					listener.valueChanged( new ControlEvent( JNumberFieldControl.this ) );
				}
			}
		);
	}
}
