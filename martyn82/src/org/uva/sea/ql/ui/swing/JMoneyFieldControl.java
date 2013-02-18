package org.uva.sea.ql.ui.swing;

import java.text.DecimalFormat;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.MoneyFieldControl;
import org.uva.sea.ql.value.MoneyValue;
import org.uva.sea.ql.value.Value;

public class JMoneyFieldControl extends MoneyFieldControl {
	private final JSpinner control;

	public JMoneyFieldControl() {
		this.control = new JSpinner( new SpinnerNumberModel( 0, null, null, 1 ) );

		JSpinner.NumberEditor editor = (JSpinner.NumberEditor) this.control.getEditor();

		DecimalFormat formatter = editor.getFormat();
		formatter.setMinimumFractionDigits( 2 );
		formatter.setMaximumFractionDigits( 2 );
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
	public MoneyValue getValue() {
		return new MoneyValue( Double.parseDouble( this.control.getValue().toString() ) );
	}

	@Override
	public void addChangeListener( final ControlEventListener listener ) {
		this.control.addChangeListener( new ChangeListener() {
			@Override
			public void stateChanged( ChangeEvent arg0 ) {
				listener.itemChanged( new ControlEvent( JMoneyFieldControl.this ) );
			}
		} );
	}
}
