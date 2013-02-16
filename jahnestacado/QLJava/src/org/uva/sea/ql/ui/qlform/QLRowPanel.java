package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class QLRowPanel {

	private final JPanel rowPanel;

	private QLRowPanel(){
		this.rowPanel = new JPanel();
		setSettings();
	}

	public static JPanel getQLRowPanel() {
		return new QLRowPanel().getPanel();

	}

	private JPanel getPanel() {
		return rowPanel;
	}

	private void setSettings() {
		rowPanel.setLayout(new MigLayout());
		rowPanel.setMinimumSize(new Dimension(617, 40));
		rowPanel.setBackground(Color.DARK_GRAY);
		rowPanel.setBorder(BorderFactory.createLineBorder(Color.white));
	}

}
