package org.uva.sea.ql.interpreter.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.interpreter.swing.panel.QuestionPanel;

public class AutoValueSetter {
	private QuestionPanel questionPanel;
	private SwingRegistry registry;

	public AutoValueSetter(SwingRegistry registry, QuestionPanel questionPanel) {
		this.registry = registry;
		this.questionPanel = questionPanel;
	}

	public void createListeners() {
		if (questionPanel.getQuestion().getType() instanceof Money) {
			Money m = (Money) questionPanel.getQuestion().getType();
			if (m.getExpr() != null) {
				List<Ident> idents = Ident.getIdents(m.getExpr());
				for (Ident i : idents) {
					QuestionPanel qp = registry.getQuestionPanelByIdent(i);
					if (qp.getQuestion().getType() instanceof Money) {
						addMoneyEvaluationListener(qp);
					}
				}
			}
		}
	}

	private void addMoneyEvaluationListener(QuestionPanel qp) {
		JTextField t = (JTextField) qp.getInput();
		t.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				evaluateMoneyValue(questionPanel);
			}
		});
		t.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				evaluateMoneyValue(questionPanel);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				evaluateMoneyValue(questionPanel);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				evaluateMoneyValue(questionPanel);

			}
		});
	}

	private void evaluateMoneyValue(QuestionPanel questionPanel) {
		if (questionPanel.getQuestion().getType() instanceof Money) {
			JTextField t = (JTextField) questionPanel.getInput();
			Money m = (Money) questionPanel.getQuestion().getType();
			if (m.getExpr() != null) {
				t.setEditable(false);
				try {
					float result = new MathEvaluator(registry,
							true).eval(m.getExpr());
					t.setText(Float.toString(result));
				} catch (EmptyInputException ex) {
					// no input? no evaluation!
				} catch (EvaluationException ex) {
					System.out.println("error: " + ex.getMessage());
				}
			}
		}
	}
}
