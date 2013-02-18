package org.uva.sea.ql.ui.swing;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.NumberFieldControl;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;

public class JNumberFieldControl extends NumberFieldControl {
	private final JFormattedTextField control;

	public JNumberFieldControl() {
		NumberFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits( 0 );
		formatter.setMinimumFractionDigits( 0 );

		this.control = new JFormattedTextField( formatter );
	}

	@Override
	public JFormattedTextField getInnerControl() {
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
	public void addChangeListener( final ControlEventListener listener ) {
		this.control.addPropertyChangeListener( "value", new PropertyChangeListener() {
			@Override
			public void propertyChange( PropertyChangeEvent evt ) {
				listener.itemChanged( new ControlEvent( JNumberFieldControl.this ) );
			}
		} );
	}
}
