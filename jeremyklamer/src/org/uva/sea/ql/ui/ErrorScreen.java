package org.uva.sea.ql.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorScreen {

	private final String errorDialogName = "Wrong input";
	
	public ErrorScreen(String error){		
		JOptionPane.showMessageDialog(new JFrame(), error, errorDialogName,
		        JOptionPane.ERROR_MESSAGE);
	}
	
}
