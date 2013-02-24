package org.uva.sea.ql;

import javax.swing.SwingUtilities;

import org.uva.sea.ql.gui.MainWindow;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
	}

}
