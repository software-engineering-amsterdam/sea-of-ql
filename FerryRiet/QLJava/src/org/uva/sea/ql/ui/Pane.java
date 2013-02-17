package org.uva.sea.ql.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observable;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.operatorresults.Result;

public abstract class Pane extends Observable implements ActionListener {

	public abstract void registerAt(JPanel parentPanel, int location);

	public abstract void updatecalculatedField(Map<String, Result> symbols);

	@Override
	public void actionPerformed(ActionEvent e) {
		throw new UnsupportedOperationException() ;
	}
}
