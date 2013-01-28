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
				System.out.println(questionPanel + " brought an expression");
				List<Ident> idents = Ident.getIdents(m.getExpr());
				for (Ident i : idents) {
					for (QuestionPanel qp : registry.getQuestions()) {
						if (qp.getIdentName().equals(i.getName())
							) {
							if(qp.getQuestion().getType() instanceof Money){
								System.out.println("try to add listener " + qp.getIdentName());
								addMoneyEvaluationListener(qp);
							}else{
								System.out.println("was not money: " + qp.getIdentName());
							}							
						}
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
		System.out.println("listeners added to " + questionPanel.getIdentName());

	}

	private void evaluateMoneyValue(QuestionPanel questionPanel) {
		if (questionPanel.getQuestion().getType() instanceof Money) {
			JTextField t = (JTextField) questionPanel.getInput();
			Money m = (Money) questionPanel.getQuestion().getType();
			if (m.getExpr() != null) {

				t.setEditable(false);
				try {
					float result = new MathEvaluator(registry.getQuestions(),
							true).eval(m.getExpr());
					t.setText(Float.toString(result));

				} catch (EvaluationException ex) {
					System.out.println("error: " + ex.getMessage());
				}
			}
		}else{
			System.out.println("Input " + questionPanel.getIdentName() + " was not of type money");
		}
	}
}
