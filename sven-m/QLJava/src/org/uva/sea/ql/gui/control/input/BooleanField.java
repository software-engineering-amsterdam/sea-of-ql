package org.uva.sea.ql.gui.control.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.UndefinedValue;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class BooleanField extends InputControl {
	private final JPanel panel;
	private final JRadioButton yesButton;
	private final JRadioButton noButton;

	public BooleanField() {
		yesButton = new JRadioButton("Yes");
		noButton = new JRadioButton("No");
		
		panel = new JPanel(new MigLayout("insets 0 0 0 0"));
		panel.add(yesButton);
		panel.add(noButton);
		
		setupActionListener();
		setupButtonGroup();
	}

	private void setupButtonGroup() {
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(getYesButton());
		buttonGroup.add(getNoButton());
	}

	private void setupActionListener() {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signalDelegate();
			}
		};
		
		getYesButton().addActionListener(actionListener);
		getNoButton().addActionListener(actionListener);
	}

	@Override
	public Value getValue() {
		boolean yesSelected = getYesButton().isSelected();
		boolean noSelected = getNoButton().isSelected();
		
		boolean defined = yesSelected || noSelected;
		
		return defined ? new BoolValue(yesSelected) : new UndefinedValue();  
	}
	
	private JRadioButton getYesButton() {
		return yesButton;
	}
	
	private JRadioButton getNoButton() {
		return noButton;
	}
	
	private JPanel getPanel() {
		return panel;
	}

	@Override
	public JComponent getWidget() {
		return getPanel();
	}

}
