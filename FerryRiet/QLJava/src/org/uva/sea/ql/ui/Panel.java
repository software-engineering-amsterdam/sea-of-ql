package org.uva.sea.ql.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.literals.Result;

public abstract class Panel {
	public Panel isActionSource(ActionEvent ev) {
		return null;
	}

	public void registerActionListener(ActionListener actionHandler) {
	}

	public void registerAt(JPanel parentPanel, int location) {

	}
	public void updatecalculatedField(HashMap<String, Result> symbols) {

	}
}
