package org.uva.sea.ql.interpreter.swing.panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.interpreter.swing.EvaluationException;
import org.uva.sea.ql.interpreter.swing.BoolEvaluator;
import org.uva.sea.ql.interpreter.swing.SwingRegistry;

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

	public void eval(SwingRegistry sr) throws EvaluationException {
		if (this.ifStatement.getCondition() instanceof ReturnsBoolOperands) {
			boolean result = new BoolEvaluator(sr.getQuestions()).eval((this.ifStatement.getCondition()));
			this.setVisible(result);
		} else {
			throw new RuntimeException("conditions for if statements must be boolean");
		}
	}

	

	
}
