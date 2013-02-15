package org.uva.sea.ql.interpreter;

import java.awt.Color;

import javax.swing.JLabel;

public class QLLabel {
	private final JLabel label;

	private QLLabel(String text, String id) {
		label = new JLabel(text);
		label.setName(id);
		setSettings();
	}

	public static JLabel getQLLabel(String text, String id) {
		text = text.replaceAll("\"", "");
		QLLabel qlLabel = new QLLabel(text, id);
		return qlLabel.getLabel();
	}

	private JLabel getLabel() {
		return label;
	}
	
	private void setSettings(){
		label.setForeground(Color.white);
	}

}
