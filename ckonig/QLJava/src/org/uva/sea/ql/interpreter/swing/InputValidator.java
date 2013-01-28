package org.uva.sea.ql.interpreter.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.interpreter.swing.panel.QuestionPanel;

public class InputValidator {
	private QuestionPanel questionPanel;
	private SwingRegistry registry;

	public InputValidator(SwingRegistry registry, QuestionPanel questionPanel) {
		this.questionPanel = questionPanel;
		this.registry = registry;
		addValidator();
	}

	private void addValidator() {
		if (questionPanel.getQuestion().getType() instanceof BooleanType) {
			JCheckBox c = (JCheckBox) questionPanel.getInput();
			c.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO validate user input
				}
			});
		}
		if (questionPanel.getQuestion().getType() instanceof Money) {
			//todo input validation
			Money m = (Money) questionPanel.getQuestion().getType();
			if(m.getExpr() != null){
				List<Ident> idents = Ident.getIdents(m.getExpr());
				for(Ident i : idents){
					for(QuestionPanel qp : registry.getQuestions()){
						if(qp.getIdentName().equals(i.getName())){
							addMoneyEvaluationListener(qp);
						}
					}
				}
			}
			
		}
		if (questionPanel.getQuestion().getType() instanceof StrType) {
			JTextField t = (JTextField) questionPanel.getInput();
			t.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO validate user input
				}
			});
			t.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO validate user input

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO validate user input

				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO validate user input

				}
			});
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

	private void evaluateMoneyValue(QuestionPanel questionPanel){
		JTextField t = (JTextField) questionPanel.getInput();
		Money m = (Money) questionPanel.getQuestion().getType();
		System.out.println("found money input");
		if (m.getExpr() != null) {
			
			t.setEditable(false);
			try {
				System.out.println("try to evaluate");
				float result = Evaluator.evalMath(m.getExpr(), registry.getQuestions(), true);
				t.setText(Float.toString(result));

			} catch (EvaluationException ex) {
				System.out.println("error: " + ex.getMessage());
			}
		}
	}
}
