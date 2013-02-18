package org.uva.sea.ql.ui.swing;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.MoneyFieldControl;
import org.uva.sea.ql.value.MoneyValue;
import org.uva.sea.ql.value.Value;

public class JMoneyFieldControl extends MoneyFieldControl {
	private final JFormattedTextField control;

	public JMoneyFieldControl() {
		NumberFormat formatter = new DecimalFormat();
		formatter.setMinimumFractionDigits( 2 );
		formatter.setMaximumFractionDigits( 2 );

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
	public MoneyValue getValue() {
		return new MoneyValue( Double.parseDouble( this.control.getValue().toString() ) );
	}

	@Override
	public void addChangeListener( final ControlEventListener listener ) {
		this.control.addPropertyChangeListener( "value", new PropertyChangeListener() {
			@Override
			public void propertyChange( PropertyChangeEvent arg0 ) {
				listener.itemChanged( new ControlEvent( JMoneyFieldControl.this ) );
			}
		} );
	}
}
