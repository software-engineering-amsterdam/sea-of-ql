package org.uva.sea.ql.ui.swing;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.MoneyFieldControl;
import org.uva.sea.ql.visitor.evaluator.value.MoneyValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

public class JMoneyFieldControl extends MoneyFieldControl {
	private final JTextField control;

	public JMoneyFieldControl() {
		this.control = new JTextField();
	}

	@Override
	public JTextField getInnerControl() {
		return this.control;
	}

	@Override
	public void setValue( Value value ) {
		this.control.setText( value.toString() );
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
		return new MoneyValue( Double.parseDouble( this.control.getText() ) );
	}

	@Override
	public void addChangeListener( final ControlEventListener listener ) {
		this.control.addFocusListener( new FocusListener() {
			@Override
			public void focusLost( FocusEvent focusEvent ) {
				listener.itemChanged( new ControlEvent( JMoneyFieldControl.this ) );
			}

			@Override
			public void focusGained( FocusEvent focusEvent ) {}
		} );
	}
}
