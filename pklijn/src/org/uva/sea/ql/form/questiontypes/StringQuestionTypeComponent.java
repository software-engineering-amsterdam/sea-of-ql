package org.uva.sea.ql.form.questiontypes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.StringValue;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.Form;

public class StringQuestionTypeComponent extends AbstractQuestionTypeComponent {

	private JTextField answerField;

	@Override
	public JComponent getAnswerField(boolean enabled, final Env environment, final Form form, final Ident id) {
		answerField = new JTextField(15);
		answerField.setEnabled(enabled);answerField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				submitResult(environment, form, id);
			}
		});
		answerField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				submitResult(environment, form, id);
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		return answerField;
	}

	@Override
	public boolean hasValue() {
		return (!answerField.getText().equals(""));
	}

	@Override
	public Value getAnswerFieldValue() {
		return new StringValue(answerField.getText());
	}

	@Override
	public void setAnswerFieldValue(Value value) {
		if (value.getClass().equals(StringValue.class)) {
			answerField.setText(((StringValue)value).getValue());
		}
		else {
			throw new IllegalArgumentException("The value given is not of the type String");
		}
		
	}

	@Override
	public void setVisible(boolean visible) {
		answerField.setVisible(visible);
	}

}
