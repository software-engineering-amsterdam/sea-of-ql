package org.uva.sea.ql.interpretation.swing;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.interpretation.exception.EvaluationException;


public class SwingRegistry {
	private List<QuestionPanel> questions;
	private List<IfStatementPanel> ifStatements;

	public SwingRegistry() {
		this.questions = new ArrayList<>();
		this.ifStatements = new ArrayList<>();
	}

	public void addQuestion(QuestionPanel q) {
		this.questions.add(q);
	}

	public void addIfStatement(IfStatementPanel i) {
		this.ifStatements.add(i);
	}

	public List<QuestionPanel> getQuestions() {
		return questions;
	}

	public List<IfStatementPanel> getIfStatements() {
		return ifStatements;
	}

	public void evaluateFunctions() {

		for (IfStatementPanel isp : ifStatements) {
			try {
				isp.eval(this);
			} catch (EvaluationException ex) {
				isp.setVisible(false);
			}
			isp.repaint();
		}
	}

	public QuestionPanel getQuestionPanelByIdent(Ident i) {
		for (QuestionPanel qp : questions) {
			if (qp.getIdentName().equals(i.getName())) {
				return qp;
			}
		}
		return null;
	}
}
