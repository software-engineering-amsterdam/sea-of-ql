package org.uva.sea.ql.gui;

public class QLApplet extends CloseableFrame {
	
	private static final long serialVersionUID = 1L;
	
	public QLApplet() { 
		super("QL Applet", 500, 500);
	} 
	
	public static void main(String[]args){
		new QLApplet();
	}
}
