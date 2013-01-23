package org.uva.sea.ql.interpreter.swing.panel;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;

public class QuestionPanel extends JPanel {
	private static final long serialVersionUID = -8537987318519877345L;
	private Question question;
	private JComponent input;
	public QuestionPanel(Question question) {
		this.question = question;
		this.add(new JLabel(question.getContent().getValue()));
		if (question.getType() instanceof BooleanType) {
			input = new JCheckBox();
			this.add(input);
		}
		if (question.getType() instanceof Money
				|| question.getType() instanceof StrType) {
			input = new JTextField(5);
			this.add(input);
		}
	}

	public Question getQuestion() {
		return question;
	}
	
	public JComponent getInput(){
		return input;
	}
}
