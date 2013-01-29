package org.uva.sea.ql.interpretation.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;


public class QuestionListener {
	private final SwingRegistry registry;

	public QuestionListener(SwingRegistry registry) {
		this.registry = registry;
	}

	public void addIdentListener(Ident ident) {
		QuestionPanel qp = registry.getQuestionPanelByIdent(ident);
		addListeners(qp);
	}

	private void addListeners(QuestionPanel questionPanel) {
		if (questionPanel.getQuestion().getType() instanceof BooleanType) {
			JCheckBox checkbox = (JCheckBox) questionPanel.getInput();
			checkbox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registry.evaluateFunctions();
				}
			});
		}
		if (questionPanel.getQuestion().getType() instanceof Money
				|| questionPanel.getQuestion().getType() instanceof StrType) {
			JTextField t = (JTextField) questionPanel.getInput();
			t.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registry.evaluateFunctions();
				}
			});
			t.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent arg0) {
					registry.evaluateFunctions();
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					registry.evaluateFunctions();

				}

				@Override
				public void keyPressed(KeyEvent arg0) {
					registry.evaluateFunctions();
				}
			});
		}

	}

}
