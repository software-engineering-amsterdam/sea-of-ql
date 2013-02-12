package org.uva.sea.ql.gui;
import java.awt.Frame;

public class CloseableFrame extends Frame {

	private static final long serialVersionUID = 1L;

	public CloseableFrame(String title, int width, int height) {
		super(title);
		
		setSize(width,height);
		setVisible(true);
		
		addWindowListener(new ExitListener());
		
		
	}
}
