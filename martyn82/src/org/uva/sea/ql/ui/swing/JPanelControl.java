package org.uva.sea.ql.ui.swing;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.ui.control.PanelControl;

public class JPanelControl extends PanelControl {
	private final JPanel control;

	public JPanelControl( String name ) {
		this.control = new JPanel();
		this.control.setName( name );
		this.control.setLayout( new BoxLayout( this.control, BoxLayout.PAGE_AXIS ) );
		this.control.add( Box.createVerticalGlue() );
	}

	public JPanelControl() {
		this( null );
	}

	@Override
	public JPanel getInnerControl() {
		return this.control;
	}

	@Override
	public void addControl( Control control ) {
		this.control.add( (JComponent) control.getInnerControl() );
	}

	@Override
	public void setEnabled( boolean enabled ) {
		this.control.setEnabled( enabled );
	}

	@Override
	public void setVisible( boolean visible ) {
		this.control.setVisible( visible );
	}
}
