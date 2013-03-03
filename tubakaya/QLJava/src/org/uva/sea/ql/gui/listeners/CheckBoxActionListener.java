package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.types.literals.BooleanLiteral;

public class CheckBoxActionListener extends QLActionListener {

	private JCheckBox checkBox;

	public CheckBoxActionListener(JPanel panel) {
		super(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BooleanLiteral booleanLiteral = new BooleanLiteral(
				checkBox.isSelected());
	}

}
