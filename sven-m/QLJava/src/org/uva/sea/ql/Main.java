package org.uva.sea.ql;

import javax.swing.SwingUtilities;

import org.uva.sea.ql.gui.MainWindow;

public class Main {

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow(args[0]);
                mainWindow.setVisible(true);
            }
        });
	}

}
