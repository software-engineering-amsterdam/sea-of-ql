package org.uva.sea.ql.interpretation.swing;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.interfaces.ReturnsBoolOperands;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

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

	public void eval(SwingRegistry registry) throws EvaluationException {
		if (this.ifStatement.getCondition() instanceof ReturnsBoolOperands) {
			boolean result = new BoolEvaluator(registry).eval((this.ifStatement
					.getCondition()));
			this.setVisible(result);
		} else {
			throw new RuntimeException(
					"conditions for if statements must be boolean");
		}
	}
}
