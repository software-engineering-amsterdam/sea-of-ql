package org.uva.sea.ql.interpreter;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import pdfgenerator.PdfGen;

public class QLGenButton implements ActionListener {

	private final JButton button = new JButton("Submit");
	private final List<JPanel> questionPanelList;
	private List<String> questionLabels;
	private List<String> questionValues;
	private final JFrame frame;
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
		PdfGen.createPdf(frame.getTitle(), questionLabels, questionValues);
	}

	private void getOutputData() {
		questionLabels = new ArrayList<String>();
        questionValues = new ArrayList<String>();
		int questionNumber = 0;
		for (JPanel question : questionPanelList) {
			
			questionNumber++;
			Component[] components = question.getComponents();

			for (int i = 0; i < components.length; i++) {
			
				if (components[i] instanceof JLabel) {
					getJLabelValue(components[i], questionNumber);
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
		
		if(hasError) return;

		for (int y = 0; y <= questionLabels.size() - 1; y++) {
			System.out.println(questionLabels.get(y) + " "
					+ questionValues.get(y));
		}

	}

	private void getJLabelValue(Component component, int questionNumber) {
		JLabel label = (JLabel) component;
		String text = label.getText();
		if(text.isEmpty()) return;

		if (text.startsWith("*") && text.endsWith("*") ){
			hasError=true;
			showMessage();
			return;
		}
		questionLabels.add(questionNumber + ". " + label.getText());
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
	
	private void showMessage(){
		  JOptionPane.showMessageDialog(frame,"Wrong input.Check input warnings!");

	}

}
