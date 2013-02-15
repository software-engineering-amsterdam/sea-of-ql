package org.uva.sea.ql.interpreter;

import java.awt.Component;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class OutputData {
	private final List<JPanel> questionPanelList;
	private final QLOutputState outputState;
	private final JFrame frame;
	private final static String computedQuestionId="COM_QUESTION_PANEL";
	private final static String questionId="QUESTION_PANEL";
	private final static String numFieldId="QLNUMFIELD";
	private final static String checkBoxId="QLCHECKBOX";
	private final static String spinnerId="QLSPINNER";
	private final static String txtFieldId="QLTEXTFIELD";
	private final static String warningId="WARNING";



	public OutputData(List<JPanel> questionPanelList, JFrame frame) {
		this.questionPanelList = questionPanelList;
		this.frame = frame;
		outputState = new QLOutputState();

	}

	public QLOutputState getOutputData() {
		gatherData();
		return outputState;
	}

	private void gatherData() {

		for (JPanel question : questionPanelList) {
			Component[] components = question.getComponents();

			for (int i = 0; i < components.length; i++) {
				String id = components[i].getName();

				if (id.equals("warningId")) {
					getWarning(components[i]);
				} else if (id.equals(computedQuestionId)|| id.equals(questionId)) {
					getJLabelValue(components[i]);
				} else if (id.equals(spinnerId)) {
					getJSpinnerValue(components[i]);
				} else if (id.equals(txtFieldId) || id.equals(numFieldId)) {
					getJTextFieldValue(components[i]);
				} else if (id.equals(checkBoxId)) {
					getJCheckBoxValue(components[i]);
				}

			}

		}

	}
	
	
	private void getWarning(Component component) {
		JLabel label = (JLabel) component;
		String text = label.getText();
		if (text.isEmpty())
			return;
		outputState.setErrorFlag(true);
		showWarning();

	}

	private void getJLabelValue(Component component) {
		JLabel label = (JLabel) component;
		String text = label.getText();
		outputState.addLabelText(text);
	}

	private void getJSpinnerValue(Component component) {
		JSpinner spinner = (JSpinner) component;
		String value = spinner.getValue().toString();
		outputState.addValue(value);
	}

	private void getJTextFieldValue(Component component) {
		JTextField txtField = (JTextField) component;
		String value = txtField.getText();
		outputState.addValue(value);
	}

	private void getJCheckBoxValue(Component component) {
		JCheckBox chBox = (JCheckBox) component;
		Boolean state = chBox.isSelected();
		outputState.addValue(state.toString());
	}

	private void showWarning() {
		JOptionPane.showMessageDialog(frame,"Wrong input.Check input warnings!");

	}
}
