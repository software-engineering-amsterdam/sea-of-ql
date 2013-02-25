package org.uva.sea.ql.runtime.ui.swing;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.uva.sea.ql.runtime.ui.IWindow;

class SwingWindow implements IWindow {

	private final JFrame window;

	public SwingWindow(final JFrame frame) {
		this.window = frame;
	}

	@Override
	public void show() {
		this.window.pack();
		this.window.setBounds(0, 0, 750, 500);
		this.window.setLocationRelativeTo(null);
		this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.window.setVisible(true);
	}

}
