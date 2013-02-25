package org.uva.sea.ql.runtime.ui.swing;

import javax.swing.JFrame;

import org.uva.sea.ql.runtime.ui.IWindow;

class SwingWindow implements IWindow {

	private final JFrame window;

	public SwingWindow(final JFrame frame) {
		this.window = frame;
	}

	@Override
	public void show() {
		this.window.pack();
		this.window.setVisible(true);
	}

}
