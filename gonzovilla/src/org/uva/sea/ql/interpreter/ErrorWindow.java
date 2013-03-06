package org.uva.sea.ql.interpreter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorWindow {
	
	public ErrorWindow(String error) {
        JFrame jFrame = new JFrame("Error Window");
        JLabel jLabel = new JLabel(error);
        jFrame.getContentPane().add(jLabel);

        jFrame.setSize(280, 200);
		jFrame.setLocation(450, 250);
        jFrame.setVisible(true);
    }
}
