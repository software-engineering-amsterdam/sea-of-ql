package org.uva.sea.ql.interpreter.swing.panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.IfStatement;

public class IfStatementPanel extends JPanel {
	private static final long serialVersionUID = -365544076190441356L;
	private IfStatement ifStatement;

	public IfStatementPanel(IfStatement ifStatement) {
		this.ifStatement = ifStatement;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public IfStatement getIfStatement() {
		return ifStatement;
	}
}
