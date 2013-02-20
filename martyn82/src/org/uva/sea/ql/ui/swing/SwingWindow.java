package org.uva.sea.ql.ui.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.control.WindowControl;

public class SwingWindow extends WindowControl {
	private final JFrame frame;

	public SwingWindow( String title, PanelControl panel ) {
		super( panel );

		this.frame = new JFrame();
		this.frame.setTitle( title );

		this.initComponents();
	}

	private void initComponents() {
		this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.frame.setLocation( 100, 100 );
		this.frame.setSize( 500, 500 );

		this.frame.add( (JPanel) this.getPanel().getInnerControl() );
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
}
