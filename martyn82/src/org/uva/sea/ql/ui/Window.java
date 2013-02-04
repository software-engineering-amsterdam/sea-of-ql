package org.uva.sea.ql.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	private static final long serialVersionUID = -6878489879835398661L;

	private final JPanel formPanel;

	public Window( String title, JPanel form ) {
		this.formPanel = form;
		this.setTitle( title );
		this.initComponents();
	}

	private void initComponents() {
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setLocation( 100, 100 );
		this.setSize( 500, 500 );

		this.add( this.formPanel );
	}
}
