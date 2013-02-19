package org.uva.sea.ql.ui.swing;

import javax.swing.JLabel;

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
	public void setVisible( boolean visible ) {
		this.control.setVisible( visible );
	}

	@Override
	public Object getInnerControl() {
		return this.control;
	}
}
