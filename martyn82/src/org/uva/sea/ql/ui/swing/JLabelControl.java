package org.uva.sea.ql.ui.swing;

import javax.swing.JLabel;

import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.LabelControl;

public class JLabelControl extends LabelControl {
	private final JLabel control;

	public JLabelControl( String text ) {
		this.control = new JLabel( text );
	}

	@Override
	public void setEnabled( boolean enabled ) {
		this.control.setEnabled( enabled );
	}

	@Override
	public Object getControl() {
		return this.control;
	}

	@Override
	public void setValue( Object value ) {
		this.setValue( (String) value );
	}

	public void setValue( String value ) {
		this.control.setText( value );
	}

	@Override
	public void setVisible( boolean visible ) {
		this.control.setVisible( visible );
	}

	@Override
	public void addChangeListener( ControlEventListener listener ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getValue() {
		return this.control.getText();
	}
}
