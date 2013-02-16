package org.uva.sea.ql.form.questiontypes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.Form;

public class BoolQuestionTypeComponent extends AbstractQuestionTypeComponent {

	private JPanel container;
	private JRadioButton buttonTrue, buttonFalse;
	
	@Override
	public JComponent getAnswerField(boolean enabled, final Env environment, final Form form, final Ident id) {
		container = new JPanel(new MigLayout("ins 1"));
		ButtonGroup bg = new ButtonGroup();
		buttonTrue = new JRadioButton("Yes");
		buttonFalse = new JRadioButton("No");
		buttonTrue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				environment.addValue(id, new BoolValue(true));
				form.eval();
			}
		});
		buttonFalse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				environment.addValue(id, new BoolValue(false));
				form.eval();
			}
		});
		buttonTrue.setEnabled(enabled);
		buttonFalse.setEnabled(enabled);
		bg.add(buttonTrue);
		bg.add(buttonFalse);
		container.add(buttonTrue);
		container.add(buttonFalse);
		return container;
	}

	@Override
	public boolean hasValue() {
		return (buttonTrue.isSelected() || buttonFalse.isSelected());
	}

	@Override
	public Value getAnswerFieldValue() {
		return new BoolValue(buttonTrue.isSelected());
	}

	@Override
	public void setAnswerFieldValue(Value value) {
		if (value.getClass().equals(BoolValue.class)) {
			if (((BoolValue)value).getValue()) {
				buttonTrue.setSelected(true);
			}
			else {
				buttonFalse.setSelected(true);
			}
		}
		else {
			throw new IllegalArgumentException("The value given is not of the type Boolean");
		}
	}

	@Override
	public void setVisible(boolean visible) {
		container.setVisible(visible);
	}
}
