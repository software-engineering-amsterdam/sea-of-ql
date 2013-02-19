package org.uva.sea.ql.ui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.ButtonControl;

public class JButtonControl extends ButtonControl {
	private final JButton control;

	public JButtonControl( String text ) {
		this.control = new JButton();
		this.control.setText( text );
	}

	@Override
	public JButton getInnerControl() {
		return this.control;
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
	public void addClickListener( final ControlEventListener listener ) {
		this.control.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent event ) {
				listener.itemChanged( new ControlEvent( JButtonControl.this ) );
			}
		} );
	}
}
