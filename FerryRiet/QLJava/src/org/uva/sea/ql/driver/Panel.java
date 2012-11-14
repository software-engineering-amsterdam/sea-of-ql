package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class Panel {
	public Panel isActionSource(ActionEvent ev) {
		return null;
	}

	public void registerActionListener(ActionListener actionHandler) {
	}

	public void registerAt(JPanel parentPanel, int location) {

	}
}
