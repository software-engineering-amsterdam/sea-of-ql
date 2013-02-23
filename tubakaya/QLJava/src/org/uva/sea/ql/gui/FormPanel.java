package org.uva.sea.ql.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class FormPanel extends JFrame{

	private static final long serialVersionUID = 1L;

	public FormPanel(String s) {
				setTitle(s);
				setSize(300,200);
				setLocation(10,200);
			
				addWindowListener(new WindowAdapter() {
				  public void windowClosing(WindowEvent e) {
					System.exit(0);
				  } 
				});
		  }
	
	public static void main(String[] args) {
		    //JFrame f = new FormPanel("My Hello World Frame");
		    //f.show();
	}
}
