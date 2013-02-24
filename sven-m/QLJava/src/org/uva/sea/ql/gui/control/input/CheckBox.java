package org.uva.sea.ql.gui.control.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.gui.InputSourceDelegate;
import org.uva.sea.ql.parser.evaluator.result.BoolValue;

public class CheckBox extends InputControl {
	private final JCheckBox checkBox;
	private ActionListener actionListener;
	
	public CheckBox() {
		checkBox = new JCheckBox();
		actionListener = null;
	}

	@Override
	public BoolValue getValue() {
		return new BoolValue(checkBox.isSelected());
	}
	
	@Override 
	public void setDelegate(InputSourceDelegate delegate) {
		super.setDelegate(delegate);
		
		checkBox.removeActionListener(actionListener);
		
		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signalDelegate();				
			}
		};
		
		checkBox.addActionListener(actionListener);
	}

	@Override
	public JComponent getWidget() {
		return checkBox;
	}

}
