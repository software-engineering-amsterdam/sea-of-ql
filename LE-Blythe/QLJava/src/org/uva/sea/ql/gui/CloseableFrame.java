package org.uva.sea.ql.gui;
import javax.swing.JFrame;

public class CloseableFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public CloseableFrame(String title, int width, int height) {
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
		setVisible(true);	
		
	}
}
