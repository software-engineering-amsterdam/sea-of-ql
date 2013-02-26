package org.uva.sea.ql.gui.control.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.gui.misc.InputSourceDelegate;
import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.UndefinedValue;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class RadioBox extends InputControl {
	private final JPanel panel;
	private final JRadioButton yesButton;
	private final JRadioButton noButton;
	private ActionListener actionListener;

	public RadioBox() {
		panel = new JPanel(new MigLayout("insets 0 0 0 0"));
		
		yesButton = new JRadioButton("Yes");
		yesButton.setActionCommand("yes");
		
		noButton = new JRadioButton("No");
		yesButton.setActionCommand("no");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(yesButton);
		buttonGroup.add(noButton);
		
		panel.add(yesButton);
		panel.add(noButton);
		
		actionListener = null;
	}

	@Override
	public Value getValue() {
		boolean yesSelected = yesButton.isSelected();
		boolean noSelected = noButton.isSelected();
		
		boolean defined = yesSelected || noSelected;
		
		return defined ? new BoolValue(yesSelected) : new UndefinedValue();  
	}

	@Override
	public void setDelegate(InputSourceDelegate delegate) {
		super.setDelegate(delegate);

		yesButton.removeActionListener(actionListener);
		noButton.removeActionListener(actionListener);

		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signalDelegate();
			}
		};

		yesButton.addActionListener(actionListener);
		noButton.addActionListener(actionListener);
	}

	@Override
	public JComponent getWidget() {
		return panel;
	}

}
