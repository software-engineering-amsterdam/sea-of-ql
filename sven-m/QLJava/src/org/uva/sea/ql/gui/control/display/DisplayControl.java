package org.uva.sea.ql.gui.control.display;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.uva.sea.ql.gui.control.Control;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class DisplayControl extends Control {
	private final JLabel label;

	public DisplayControl() {
		label = new JLabel();
	}

	public void setValue(Value value) {
		label.setText(StringProducer.toString(value));
	}

	protected JLabel getLabel() {
		return label;
	}

	public JComponent getWidget() {
		return label;
	}

}
