package org.uva.sea.ql.interpreter;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class QLGenButton implements ActionListener {

	private final JButton button = new JButton("Generate");
	private final List<JPanel> questionPanelList;
	private List<String> questionLabels;
	private List<String> questionValues;
	private final JFrame frame;
	@SuppressWarnings("unused")
	private boolean hasError;

	private QLGenButton(List<JPanel> questionPanelList,JFrame frame) {
		this.questionPanelList = questionPanelList;
		this.frame=frame;
		button.addActionListener(this);
	}

	public static JButton responsiveButton(List<JPanel> questionPanelList,JFrame frame) {
		QLGenButton genButton = new QLGenButton(questionPanelList,frame);
		return genButton.getButton();
	}

	private JButton getButton() {
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		hasError=false;
		getOutputData();
		showSelectorDialog();
	
	}

	private void getOutputData() {
		questionLabels = new ArrayList<String>();
        questionValues = new ArrayList<String>();
		for (JPanel question : questionPanelList) {
			
			Component[] components = question.getComponents();

			for (int i = 0; i < components.length; i++) {
			
				if (components[i] instanceof JLabel) {
					getJLabelValue(components[i]);
				}
				if (components[i] instanceof JSpinner) {
					getJSpinnerValue(components[i]);
				}
				if (components[i] instanceof JTextField) {
					getJTextFieldValue(components[i]);
				}
				if (components[i] instanceof JCheckBox) {
					getJCheckBoxValue(components[i]);
				}
			}
		}
		
		
	}

	private void getJLabelValue(Component component) {
		JLabel label = (JLabel) component;
		String text = label.getText();
		
		if (label.getName().equals("WARNING") ){
			if(text.isEmpty()) return;
			hasError=true;
			showSelectorDialogessage();
			return;
		}
		questionLabels.add(text);
	}

	private void getJSpinnerValue(Component component) {
		JSpinner spinner = (JSpinner) component;
		String value = spinner.getValue().toString();
		questionValues.add(value);
	}

	private void getJTextFieldValue(Component component) {
		JTextField txtField = (JTextField) component;
		String value = txtField.getText();
		questionValues.add(value);
	}

	private void getJCheckBoxValue(Component component) {
		JCheckBox chBox = (JCheckBox) component;
		Boolean state = chBox.isSelected();
		questionValues.add(state.toString());
	}
	
	private void showSelectorDialogessage(){
		  JOptionPane.showMessageDialog(frame,"Wrong input.Check input warnings!");

	}
	
	private void showSelectorDialog(){
		String formName=frame.getTitle();
		QLOutputSelectorFrame.showFormatSelector(formName,questionLabels, questionValues);
		
	}

}
