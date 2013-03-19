package org.uva.sea.ql.renderer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorBox {
	
	private final static String dialogName = "Error(s)";
	
	public ErrorBox(String errorMessage) {
		JOptionPane.showMessageDialog(new JFrame(), errorMessage, dialogName,
		        JOptionPane.ERROR_MESSAGE);
		
	}

}
