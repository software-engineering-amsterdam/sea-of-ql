package org.uva.sea.ql.gui.control.input;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class NumberField extends InputControl {
	private final JSpinner spinner;

	public NumberField() {
		spinner = new JSpinner(new SpinnerNumberModel());
		
        Dimension d = spinner.getPreferredSize();  
        d.width = 100;  
        spinner.setPreferredSize(d);
		
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				signalDelegate();
			}
		});
	}

	@Override
	public Value getValue() {
		return new IntValue((Integer) getSpinner().getValue());
	}

	private JSpinner getSpinner() {
		return spinner;
	}
	
	@Override
	public JComponent getWidget() {
		return getSpinner();
	}

}
