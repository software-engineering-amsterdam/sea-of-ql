package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class QLActionListener implements ActionListener {

	private JPanel panel;

	public QLActionListener(JPanel panel) {
		this.panel = panel;
	}

	protected void updateFrame() {
	}
}
