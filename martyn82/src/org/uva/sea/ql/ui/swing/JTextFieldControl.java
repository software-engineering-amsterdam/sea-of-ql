package org.uva.sea.ql.ui.swing;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.TextFieldControl;

public class JTextFieldControl extends TextFieldControl {
	private final JTextField control;

	public JTextFieldControl() {
		this.control = new JTextField();
	}

	@Override
	public JTextField getControl() {
		return this.control;
	}

	@Override
	public void setValue( Object value ) {
		this.setValue( value.toString() );
	}

	public void setValue( String value ) {
		this.control.setText( value );
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
	public String getValue() {
		return this.control.getText();
	}

	@Override
	public void addChangeListener( final ControlEventListener listener ) {
		this.control.addFocusListener( new FocusListener() {
			@Override
			public void focusLost( FocusEvent focusEvent ) {
				JTextField component = (JTextField) focusEvent.getSource();
				JTextFieldControl.this.setValue( component.getText() );

				listener.itemChanged( new ControlEvent( JTextFieldControl.this ) );
			}

			@Override
			public void focusGained( FocusEvent focusEvent ) {}
		} );
	}
}
