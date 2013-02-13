package org.uva.sea.ql.ui.swing;

import javax.swing.JLabel;

import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.LabelControl;
import org.uva.sea.ql.visitor.evaluator.value.StringValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

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
	public void setVisible( boolean visible ) {
		this.control.setVisible( visible );
	}

	@Override
	public void setValue( Value value ) {
		this.control.setText( value.toString() );
	}

	@Override
	public StringValue getValue() {
		return new StringValue( this.control.getText() );
	}

	@Override
	public Object getInnerControl() {
		return this.control;
	}

	@Override
	public void addChangeListener( ControlEventListener listener ) {
		throw new UnsupportedOperationException();
	}
}
