package org.uva.sea.ql.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.operatorresults.Result;

public abstract class Panel extends Observable implements ActionListener {

	public void registerAt(JPanel parentPanel, int location) {

	}

	public void updatecalculatedField(HashMap<String, Result> symbols) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
