package org.uva.sea.ql.gui.control.input;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

import org.uva.sea.ql.gui.misc.InputSourceDelegate;
import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class NumberField extends InputControl {
	private final JSpinner spinner;
	private ChangeListener changeListener;

	public NumberField() {
		spinner = new JSpinner(new SpinnerNumberModel());

		JFormattedTextField textField =
				((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();

		textField.setSize(5, textField.getHeight());

		DefaultFormatter formatter =
				(DefaultFormatter) textField.getFormatter();
		formatter.setCommitsOnValidEdit(true);

	}

	@Override
	public Value getValue() {
		return new IntValue((Integer) spinner.getValue());
	}

	@Override
	public void setDelegate(InputSourceDelegate delegate) {
		super.setDelegate(delegate);

		spinner.removeChangeListener(changeListener);

		changeListener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				signalDelegate();
			}
		};

		spinner.addChangeListener(changeListener);
	}

	@Override
	public JComponent getWidget() {
		return spinner;
	}

}
