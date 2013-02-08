package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

public abstract class Panel implements VisitorResult{
	public Panel isActionSource(ActionEvent ev) {
		return null;
	}
	public void registerActionListener(ActionListener actionHandler) {
	}
	public void registerAt(JPanel parentPanel, int location) {
		
	}
}
