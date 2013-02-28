package org.uva.sea.ql.gui.control;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;


public class Applet {

	private final JComponent rootControl;
	private final String name;
	private final int width, height;
	
	public Applet(final JComponent rootControl, final String name, final int width, final int height){
       this.rootControl = rootControl;
       this.name = name;
       this.width = width;
       this.height = height;
	}
	
	
	public void run(){
		
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new CloseableFrame(rootControl, name, width, height);
	            }
	         });
	}
}
