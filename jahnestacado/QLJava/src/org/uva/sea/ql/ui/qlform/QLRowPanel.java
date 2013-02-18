package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class QLRowPanel {
	public final static String QL_QUESTION_PANEL="QL_QUESTION_PANEL";
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
		rowPanel.setName(QL_QUESTION_PANEL);
		rowPanel.setMinimumSize(new Dimension(617, 40));
		rowPanel.setBackground(Color.gray);
		rowPanel.setBorder(BorderFactory.createLineBorder(Color.white));
	}

}
