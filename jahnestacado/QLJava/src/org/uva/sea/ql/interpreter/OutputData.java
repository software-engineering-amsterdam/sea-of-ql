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

				if (id.equals(QLInputVerifier.WARNING_LABEL_ID)) {
					getWarning(components[i]);
				} else if (id.equals(ComputedQuestionPanel.COM_QUESTION_PANEL)|| id.equals(QuestionPanel.QL_QUESTION_LABEL_ID)) {
					getJLabelValue(components[i]);
				} else if (id.equals(QLSpinner.QL_SPINNER_ID)) {
					getJSpinnerValue(components[i]);
				} else if (id.equals(QLTextField.QL_TXT_FIELD_ID)
						|| id.equals(QLNumField.NUM_FIELD_ID)
						|| id.equals(QLComputedField.QL_COMPUTED_FIELD_ID)) {
					getJTextFieldValue(components[i]);
				} else if (id.equals(QLCheckBox.QL_CHECKBOX_ID)) {
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
