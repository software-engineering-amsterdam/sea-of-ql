package org.uva.sea.ql.ui.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.control.WindowControl;

public class SwingWindow extends WindowControl {
	private final JFrame frame;

	public SwingWindow() {
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.frame.setLocation( 100, 100 );
		this.frame.setSize( 500, 500 );
	}

	@Override
	public JFrame getInnerControl() {
		return this.frame;
	}

	@Override
	public void setTitle( String title ) {
		this.frame.setTitle( title );
	}

	@Override
	public void addControl( PanelControl panel ) {
		this.frame.add( (JPanel) panel.getInnerControl() );
	}

	@Override
	public void pack() {
		this.frame.pack();
	}

	@Override
	public void show() {
		this.frame.setVisible( true );
	}

	@Override
	public void hide() {
		this.frame.setVisible( false );
	}

	@Override
	public void close() {
		this.frame.dispose();
	}
}
