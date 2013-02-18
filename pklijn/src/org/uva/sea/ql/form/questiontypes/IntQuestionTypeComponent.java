package org.uva.sea.ql.form.questiontypes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.Form;

public class IntQuestionTypeComponent extends AbstractQuestionTypeComponent {

	private JTextField answerField;
	
	@Override
	public JComponent getAnswerField(boolean enabled, final Env environment, final Form form, final Ident id) {
		answerField = new JTextField(15);
		answerField.setEnabled(enabled);
		answerField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidInteger())
					submitResult(environment, form, id);
				else
					showErrorMessageAndClearField();
			}
		});
		answerField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (isValidInteger()) {
					submitResult(environment, form, id);
				}
				else if (!answerField.getText().equals("")) {
					showErrorMessageAndClearField();
				}
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		return answerField;
	}

	@Override
	public boolean hasValue() {
		return isValidInteger();
	}

	@Override
	public Value getAnswerFieldValue() {
		if(isValidInteger())
			return new IntValue(Integer.parseInt(answerField.getText()));
		return new IntValue();
	}

	@Override
	public void setAnswerFieldValue(Value value) {
		if (value.getClass().equals(IntValue.class)) {
			answerField.setText(((IntValue)value).getValue().toString());
		}
		else {
			throw new IllegalArgumentException("The value given is not of the type Integer");
		}
	}

	private boolean isValidInteger() {
		try {
			Integer.parseInt(answerField.getText());
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private void showErrorMessageAndClearField() {
		JOptionPane.showMessageDialog(null, "The value should be an Integer!");
		answerField.setText("");
	}

	@Override
	public void setVisible(boolean visible) {
		answerField.setVisible(visible);
	}
}
