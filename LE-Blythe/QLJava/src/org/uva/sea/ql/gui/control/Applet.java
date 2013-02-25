package org.uva.sea.ql.gui.control;

import javax.swing.SwingUtilities;


public class Applet {

	public Applet(final Control rootControl, final String name, final int width, final int height){
		
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame(rootControl, name, width, height);
            }
         });
	}
}
