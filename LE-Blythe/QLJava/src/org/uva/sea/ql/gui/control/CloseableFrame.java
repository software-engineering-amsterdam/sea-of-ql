package org.uva.sea.ql.gui.control;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CloseableFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JComponent rootComponent;
	
	public CloseableFrame(JComponent cmp, String title, int width, int height){
		super();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width,height);
		this.setVisible(true);	
		
		rootComponent = cmp;
		this.getContentPane().add(rootComponent);
	}
	

	protected JComponent getComponent() {
		return rootComponent;
	}

}
